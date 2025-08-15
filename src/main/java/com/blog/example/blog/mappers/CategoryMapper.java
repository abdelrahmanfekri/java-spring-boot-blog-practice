package com.blog.example.blog.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.blog.example.blog.domain.entities.Category;
import com.blog.example.blog.domain.entities.Post;
import com.blog.example.blog.domain.PostStatus;
import com.blog.example.blog.domain.dtos.CategoryDto;
import com.blog.example.blog.domain.dtos.CreateCategoryDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryDto createCategoryDto);

    @Named("calculatePostCount")
    default Long calculatePostCount(List<Post> posts) {
        if (posts == null) {
            return 0L;
        }
        return posts.stream().filter( post -> post.getStatus().equals(PostStatus.PUBLISHED)).count();
    }

}
