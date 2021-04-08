package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);

    void deleteCategory(Category category);

    List<Category> findCategories();

//    Category findCategoryById(int idCategory);
}
