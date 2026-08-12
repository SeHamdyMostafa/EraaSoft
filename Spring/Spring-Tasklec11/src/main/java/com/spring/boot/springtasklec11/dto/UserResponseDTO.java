package com.spring.boot.springtasklec11.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserResponseDTO {
    private Long id;
    private String name;
    private Integer age;

}
