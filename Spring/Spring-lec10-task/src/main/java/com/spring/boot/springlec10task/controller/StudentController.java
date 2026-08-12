package com.spring.boot.springlec10task.controller;


import com.spring.boot.springlec10task.Dto.StudentDto;
import com.spring.boot.springlec10task.Dto.StudentWithTeachersDto;
import com.spring.boot.springlec10task.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentServiceImp studentServiceImpl;
    @Autowired
    public StudentController(StudentServiceImp studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }
    // http://localhost:8085/api/students/5
    @GetMapping("/{id}")
    public StudentWithTeachersDto getStudentsById(@PathVariable Long id) {
        return studentServiceImpl.getStudentWithTeachersById(id);
    }

    // http://localhost:8085/api/students
    @GetMapping
    public List<StudentWithTeachersDto> getAllStudents() {
        return studentServiceImpl.getAllStudentsWithTeachers();
    }

}
