package com.spring.boot.springlec10task.service;

import com.spring.boot.springlec10task.Dto.StudentDto;
import com.spring.boot.springlec10task.Dto.StudentWithTeachersDto;
import com.spring.boot.springlec10task.model.Student;

import java.util.List;

public interface StudentService {

    StudentWithTeachersDto getStudentWithTeachersById (Long id);

    List<StudentWithTeachersDto> getAllStudentsWithTeachers ();

}
