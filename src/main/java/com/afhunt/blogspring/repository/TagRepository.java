package com.afhunt.blogspring.repository;

import com.afhunt.blogspring.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
    List<TagEntity> findByName(String name);
}
