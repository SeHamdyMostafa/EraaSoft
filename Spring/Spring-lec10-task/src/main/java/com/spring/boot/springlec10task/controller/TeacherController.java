package com.spring.boot.springlec10task.controller;


import com.spring.boot.springlec10task.Dto.TeacherDto;
import com.spring.boot.springlec10task.Dto.TeacherWithStudentsDto;
import com.spring.boot.springlec10task.service.TeacherService;
import com.spring.boot.springlec10task.service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Teachers")
public class TeacherController {

    private final TeacherServiceImp teacherServiceImp;
    @Autowired
    public TeacherController(TeacherServiceImp teacherServiceImp) {
        this.teacherServiceImp = teacherServiceImp;
    }

    // http://localhost:8085/api/Teachers/5
    @GetMapping("/{id}")
    public TeacherWithStudentsDto getTeacherById(@PathVariable Long id) {
        return teacherServiceImp.getTeacherWithStudentsById(id);
    }

    // http://localhost:8085/api/Teachers
    @GetMapping
    public List<TeacherWithStudentsDto> getAllTeachers() {
        return teacherServiceImp.getAllTeachersWithStudents();
    }
}
