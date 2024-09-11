package com.example.courseportal.controller;

import com.example.courseportal.entity.Course;
import com.example.courseportal.entity.Student;
import com.example.courseportal.entity.Teacher;
import com.example.courseportal.service.CourseService;
import com.example.courseportal.service.StudentService;
import com.example.courseportal.service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MainController {

    private CourseService courseService;
    private StudentService studentService;
    private TeacherService teacherService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login/{role}")
    public String login(@PathVariable String role , Model model) {
        if (role.equals("student")) {
            model.addAttribute("user", new Student());
        }
        else if (role.equals("teacher")) {
            model.addAttribute("user", new Teacher());
        }
        else return "redirect:/";
        model.addAttribute("role", role);
        model.addAttribute("courseList", courseService.getAllCourses());
        return "login";
    }

    @PostMapping(value = "/login/{role}")
    public String save(@PathVariable String role ,@Valid Student studentForm,
                        @Valid Teacher teacherForm, BindingResult bindingResult , Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("role", role);
            model.addAttribute("courseList", courseService.getAllCourses());
            return "login";
        }
        if(role.equals("student")) {
            studentService.save(studentForm);
        }else if(role.equals("teacher")) {
            teacherService.saveTeacher(teacherForm);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/submit-course")
    public String submit(Model model) {
        model.addAttribute("courseForm", new Course());
        model.addAttribute("teacherList", teacherService.getAllTeachers());
        return "submit_course";
    }

    @PostMapping(value = "/submit-course")
    public String submit(@Valid Course courseForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("teacherList", teacherService.getAllTeachers());
            return "submit_course";
        }
        System.out.println("555555555");
        courseService.saveCourse(courseForm);
        System.out.println(courseService.getAllCourses());
        return "redirect:/";
    }
}
