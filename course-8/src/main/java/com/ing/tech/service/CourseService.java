package com.ing.tech.service;

import com.ing.tech.model.dao.Course;
import com.ing.tech.model.dto.CourseDTO;
import com.ing.tech.model.dto.CourseList;
import com.ing.tech.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private TeacherService teacherService;
    private CourseRepository courseRepository;

    public CourseService(TeacherService teacherService, CourseRepository courseRepository) {
        this.teacherService = teacherService;
        this.courseRepository = courseRepository;
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }

    public CourseDTO updateCourse(Course course) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }

    public CourseList getAllCourses(Optional<String> domain) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }

    Course getCourseById(Long id) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented");
    }

    private Course mapCourseDTOtoDAO(CourseDTO courseDTO) {
        return new Course(null, courseDTO.getName(), courseDTO.getDetails(), courseDTO.getLocation(),
                courseDTO.getDateTime(), courseDTO.getDuration(), courseDTO.getMaxParticipants(),
                courseDTO.getDomain(), 0, null, null);
    }

    CourseDTO mapCourseDAOtoDTO(Course course) {
        return new CourseDTO(course.getId(), course.getName(), course.getDetails(), course.getLocation(),
                course.getDateTime(), course.getDuration(), course.getMaxParticipants(), course.getDomain(),
                course.getTeacher().getPhoneNumber(), course.getParticipants());
    }

}
