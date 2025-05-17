package com.example.studentapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String rollNumber;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false)
    private String courseEnrolled;

    // Getters and setters here (or use Lombok)
    
    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) {
    	this.id = id; 
    }
    public String getFullName() { 
    	return fullName; 
    }
    public void setFullName(String fullName) { 
    	this.fullName = fullName; 
    }
    public String getRollNumber() { 
    	return rollNumber; 
    }
    public void setRollNumber(String rollNumber) { 
    	this.rollNumber = rollNumber; 
    }
    public String getCollegeName() { 
    	return collegeName; 
    }
    public void setCollegeName(String collegeName) { 
    	this.collegeName = collegeName; 
    }
    public String getCourseEnrolled() { 
    	return courseEnrolled; 
    }
    public void setCourseEnrolled(String courseEnrolled) { 
    	this.courseEnrolled = courseEnrolled; 
    }
}
