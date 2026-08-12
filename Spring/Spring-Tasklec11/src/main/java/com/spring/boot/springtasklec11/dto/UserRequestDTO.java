package com.spring.boot.springtasklec11.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    @NotNull(message = "Name cannot be null")
    @Size(min = 8, message = "Name size must be greater than 7 characters")
    private String name;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotNull(message = "Password cannot be null")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",
            message = "Password must contain upper case, lower case, number and special char"
    )
    private String password;
}