package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student register(Student student) {
        try {
            return studentRepository.save(student);
        } catch (DataIntegrityViolationException e) {
            // Handle data integrity issues, such as duplicate roll number
            throw new RuntimeException("Student with this Roll Number already exists");
        } catch (Exception e) {
            // Log the exception
            throw new RuntimeException("An error occurred while registering the student");
        }
    }

    public List<Student> getAll() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            // Log the exception
            throw new RuntimeException("An error occurred while fetching students");
        }
    }

    public boolean deleteStudentByIdOrRollNumber(String input) {
        try {
            // Try parse input as Long ID
            try {
                Long id = Long.parseLong(input);
                Optional<Student> studentById = studentRepository.findById(id);
                if (studentById.isPresent()) {
                    studentRepository.delete(studentById.get());
                    return true;
                }
            } catch (NumberFormatException e) {
                // input is not a number, treat as roll number
            }

            // Try find by roll number (assuming rollNumber is unique)
            Optional<Student> studentByRoll = studentRepository.findByRollNumber(input);
            if (studentByRoll.isPresent()) {
                studentRepository.delete(studentByRoll.get());
                return true;
            }

            // Not found by either ID or roll number
            return false;
        } catch (Exception e) {
            // Log the exception
            throw new RuntimeException("An error occurred while deleting the student");
        }
    }
}
