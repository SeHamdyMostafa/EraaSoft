package com.spring.boot.springlec10task.mapper;

import com.spring.boot.springlec10task.Dto.TeacherDto;
import com.spring.boot.springlec10task.Dto.TeacherWithStudentsDto;
import com.spring.boot.springlec10task.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {


   TeacherWithStudentsDto toTeacherWithStudentsDto(Teacher teacher);
    List<TeacherWithStudentsDto> toTeacherWithTeachersDtoList(List<Teacher> teachers);
}