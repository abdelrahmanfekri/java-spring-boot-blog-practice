package com.blog.example.blog.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCategoryDto {
    @NotBlank(message = "Name is required")
    private String name;

}
