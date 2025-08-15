package com.blog.example.blog.domain.dtos;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private UUID id;
    private String name;
    private long postCount;
}
