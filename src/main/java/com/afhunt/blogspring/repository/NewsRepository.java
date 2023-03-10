package com.afhunt.blogspring.repository;

import com.afhunt.blogspring.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    List<NewsEntity> findByName(String name);

    List<NewsEntity> findByNameContainsOrDescriptionContainsAllIgnoreCase(String name, String description);

    List<NewsEntity> findByNameContainsIgnoreCase(String name);

    List<NewsEntity> findByDescriptionContainsIgnoreCase(String description);
}