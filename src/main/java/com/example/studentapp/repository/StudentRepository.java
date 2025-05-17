package com.example.studentapp.repository;

import com.example.studentapp.model.Student;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//database operations.

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRollNumber(String rollNumber) throws DataAccessException;
}
