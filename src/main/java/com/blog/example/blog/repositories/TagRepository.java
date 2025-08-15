package com.blog.example.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.blog.example.blog.domain.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
    
}
