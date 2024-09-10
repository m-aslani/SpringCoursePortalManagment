package com.example.courseportal.service.impl;

import com.example.courseportal.entity.Course;
import com.example.courseportal.repository.CourseRepository;
import com.example.courseportal.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@AllArgsConstructor
public class CourseImpl implements CourseService {

    private CourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }

    @Override
    public void saveCourse(Course course) {

    }
}
