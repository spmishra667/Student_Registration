package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student register(Student student) {
        return studentRepository.save(student);
    }

    public java.util.List<Student> getAll() {
        return studentRepository.findAll();
    }

    public boolean deleteStudentByIdOrRollNumber(String input) {
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
    }
}
