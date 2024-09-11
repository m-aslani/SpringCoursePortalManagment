package com.example.courseportal.service.impl;

import com.example.courseportal.entity.Teacher;
import com.example.courseportal.repository.TeacherRepository;
import com.example.courseportal.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class TeacherImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
