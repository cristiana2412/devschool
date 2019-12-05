package com.ing.tech.service;

import com.ing.tech.model.dao.Student;
import com.ing.tech.model.dto.CourseIdentifier;
import com.ing.tech.model.dto.CourseList;
import com.ing.tech.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private CourseService courseService;
    private StudentRepository studentRepository;

    public StudentService(CourseService courseService, StudentRepository studentRepository) {
        this.courseService = courseService;
        this.studentRepository = studentRepository;
    }

    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void enroll(String phoneNumber, CourseIdentifier courseIdentifier) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Transactional
    public void withdraw(String phoneNumber, Long idCourse) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Student identifyStudent(String phoneNumber) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }

    public CourseList getAllCourses(String phoneNumber) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }
}
