package com.ing.tech.controller;

import com.ing.tech.model.dao.Teacher;
import com.ing.tech.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        //TODO 1
        throw new UnsupportedOperationException("Not Implemented");
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Teacher> identifyTeacher(@PathVariable String phoneNumber) {
        //TODO 2
        throw new UnsupportedOperationException("Not Implemented");
    }

}
