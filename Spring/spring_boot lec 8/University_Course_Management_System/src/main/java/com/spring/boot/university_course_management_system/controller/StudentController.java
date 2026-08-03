package com.spring.boot.university_course_management_system.controller;

import com.spring.boot.university_course_management_system.model.Student;
import com.spring.boot.university_course_management_system.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // http://localhost:8082/api/students
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // http://localhost:8082/api/students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // http://localhost:8082/api/students/5
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // http://localhost:8082/api/students/5/courses/1
    @PutMapping("/{studentId}/courses/{courseId}")
    public Student registerCourse(@PathVariable Long studentId,
                                  @PathVariable Long courseId) {

        return studentService.registerCourse(studentId, courseId);
    }
}