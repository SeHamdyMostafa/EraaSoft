package com.spring.boot.springtasklec11.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostResponseDTO {
    private Long id;
    private String text;
    private String imagePath;

}
