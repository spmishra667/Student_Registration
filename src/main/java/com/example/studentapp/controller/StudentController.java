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
@CrossOrigin(origins = "*") // Allow CORS for frontend
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        System.out.println("Registering student: " + student.getFullName() + ", Roll Number: " + student.getRollNumber());
        return service.register(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    @DeleteMapping("/delete/{input}")
    public ResponseEntity<?> deleteStudent(@PathVariable String input) {
        boolean deleted = service.deleteStudentByIdOrRollNumber(input);
        if (deleted) {
        	
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
        }
    }
}
