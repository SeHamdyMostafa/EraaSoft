package com.spring.boot.springlec10task.service;

import com.spring.boot.springlec10task.Dto.StudentWithTeachersDto;
import com.spring.boot.springlec10task.mapper.StudentMapper;
import com.spring.boot.springlec10task.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    @Override
    public StudentWithTeachersDto getStudentWithTeachersById(Long id) {
        return studentMapper.toStudentWithTeachersDto(studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found")));
    }

    @Override
    public List<StudentWithTeachersDto> getAllStudentsWithTeachers() {
        return  studentMapper.toStudentWithTeachersDtoList(studentRepository.findAll());
    }
}
