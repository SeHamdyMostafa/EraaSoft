package com.spring.boot.springlec10task.mapper;

import com.spring.boot.springlec10task.Dto.StudentDto;
import com.spring.boot.springlec10task.Dto.StudentWithTeachersDto;
import com.spring.boot.springlec10task.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentWithTeachersDto toStudentWithTeachersDto(Student student);
    List<StudentWithTeachersDto> toStudentWithTeachersDtoList(List<Student> students);
}