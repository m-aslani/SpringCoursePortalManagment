package com.example.courseportal.service;

import com.example.courseportal.entity.Course;

import java.util.List;

public interface CourseService {
    public Course getCourse(Long id);
    public List<Course> getAllCourses();
    public void saveCourse(Course course);
}
