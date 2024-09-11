package com.example.courseportal.service.impl;

import com.example.courseportal.entity.Course;
import com.example.courseportal.repository.CourseRepository;
import com.example.courseportal.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class CourseImpl implements CourseService {

    private CourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }
}
