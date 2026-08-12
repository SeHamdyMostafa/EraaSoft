package com.spring.boot.springlec10task.service;

import com.spring.boot.springlec10task.Dto.TeacherWithStudentsDto;
import com.spring.boot.springlec10task.mapper.TeacherMapper;
import com.spring.boot.springlec10task.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImp(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }


    @Override
    public TeacherWithStudentsDto getTeacherWithStudentsById(Long id) {
        return teacherMapper.toTeacherWithStudentsDto(teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher Not Found")));
    }

    @Override
    public List<TeacherWithStudentsDto> getAllTeachersWithStudents() {
        return teacherMapper.toTeacherWithTeachersDtoList(teacherRepository.findAll());
    }
}
