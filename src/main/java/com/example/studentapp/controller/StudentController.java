package com.example.studentapp.controller;

import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        try {
            Student registeredStudent = service.register(student);
            return new ResponseEntity<>(registeredStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Note: update frontend to read message
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = service.getAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{input}")
    public ResponseEntity<String> deleteStudent(@PathVariable String input) {
        try {
            boolean deleted = service.deleteStudentByIdOrRollNumber(input);
            if (deleted) {
                return ResponseEntity.ok("Student deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
            }
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete student");
        }
    }
}
