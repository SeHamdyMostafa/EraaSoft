package com.spring.boot.university_course_management_system.service;

import com.spring.boot.university_course_management_system.model.Student;
import com.spring.boot.university_course_management_system.repo.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student CreateStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> GetAllStudents(Student student){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student Not Found"));
    }


}
