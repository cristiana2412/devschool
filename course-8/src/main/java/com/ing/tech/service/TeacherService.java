package com.ing.tech.service;

import com.ing.tech.model.dao.Teacher;
import com.ing.tech.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher insertTeacher(Teacher teacher) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Teacher identifyTeacher(String phoneNumber) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }
}
