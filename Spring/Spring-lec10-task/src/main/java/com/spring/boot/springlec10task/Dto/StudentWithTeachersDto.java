package com.spring.boot.springlec10task.Dto;

import java.util.Set;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithTeachersDto {
    private Long id;
    private String name;
    private Set<TeacherDto> teachers;
}