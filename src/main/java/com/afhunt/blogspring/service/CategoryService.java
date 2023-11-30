package com.afhunt.blogspring.service;

import com.afhunt.blogspring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List getCategories() {
        return categoryRepository.findAll();
    }
}
