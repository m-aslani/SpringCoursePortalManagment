package com.example.courseportal.service;

import com.example.courseportal.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeachers();
    public Teacher getTeacherById(Long id);
    public Teacher saveTeacher(Teacher teacher);
}
