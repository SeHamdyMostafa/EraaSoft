package com.spring.boot.springlec10task.Dto;

import java.util.Set;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherWithStudentsDto {
    private Long id;
    private String name;
    private Set<StudentDto> students;
}