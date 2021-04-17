package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

// TODO сделать общий интерфейс CRUD
public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);

    void deleteCategory(Long id);

    List<Category> findCategories();

    Optional<Category> findById(Long id);
}
