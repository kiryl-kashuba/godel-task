package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> deleteCategory(int idCategory);

    List<Category> findCategories();

    Category findCategoryById(int idCategory);
}
