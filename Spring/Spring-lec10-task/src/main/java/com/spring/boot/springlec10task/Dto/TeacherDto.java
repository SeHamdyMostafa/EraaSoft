package com.spring.boot.springlec10task.Dto;


import lombok.*;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
    private Long id;
    private String name;
}