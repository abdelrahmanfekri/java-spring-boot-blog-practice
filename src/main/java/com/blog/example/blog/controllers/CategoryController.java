package com.blog.example.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.blog.example.blog.domain.dtos.CategoryDto;
import com.blog.example.blog.domain.dtos.CreateCategoryDto;
import com.blog.example.blog.domain.entities.Category;
import com.blog.example.blog.mappers.CategoryMapper;
import com.blog.example.blog.services.CategoryService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categoryDtos = categoryService.listCategories().stream()
            .map(categoryMapper::toDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(categoryDtos);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryDto categoryCreateDto) {
        Category category = categoryMapper.toEntity(categoryCreateDto);
        Category savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(categoryMapper.toDto(savedCategory), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
