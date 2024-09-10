package com.example.courseportal.service;

import com.example.courseportal.entity.Student;

import java.util.List;

public interface StudentService {

    public void save(Student student);
    public List<Student> findAll();
    public Student findById(Long id);
}
