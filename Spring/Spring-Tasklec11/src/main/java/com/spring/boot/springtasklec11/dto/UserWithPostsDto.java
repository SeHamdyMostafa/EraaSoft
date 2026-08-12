package com.spring.boot.springtasklec11.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserWithPostsDto {
    private Long id;
    private String name;
    private Integer age;
    private List<PostRequestDTO> posts;
}