package com.spring.boot.springlec10task.service;

import com.spring.boot.springlec10task.Dto.TeacherDto;
import com.spring.boot.springlec10task.Dto.TeacherWithStudentsDto;
import com.spring.boot.springlec10task.model.Student;

import java.util.List;

public interface TeacherService {

    TeacherWithStudentsDto getTeacherWithStudentsById (Long id);

    List<TeacherWithStudentsDto> getAllTeachersWithStudents ();

}
