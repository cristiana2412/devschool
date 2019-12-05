package com.ing.tech.controller;

import com.ing.tech.model.dao.Student;
import com.ing.tech.model.dto.CourseIdentifier;
import com.ing.tech.model.dto.CourseList;
import com.ing.tech.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        //TODO 3
        throw new UnsupportedOperationException("Not Implemented");
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Student> identifyStudent(@PathVariable String phoneNumber) {
        //TODO 4
        throw new UnsupportedOperationException("Not Implemented");
    }

    @PostMapping("/{phoneNumber}/courses")
    public ResponseEntity attendCourse(@PathVariable String phoneNumber, @RequestBody CourseIdentifier courseIdentifier) {
        //TODO 7
        throw new UnsupportedOperationException("Not Implemented");
    }

    @DeleteMapping("/{phoneNumber}/courses/{idCourse}")
    public ResponseEntity withdrawCourse(@PathVariable String phoneNumber, @PathVariable Long idCourse) {
        //TODO 8
        throw new UnsupportedOperationException("Not Implemented");
    }

    @GetMapping("/{phoneNumber}/courses")
    public ResponseEntity<CourseList> getAllCoursesByStudent(@PathVariable String phoneNumber) {
        //TODO 9
        throw new UnsupportedOperationException("Not Implemented");
    }
}
