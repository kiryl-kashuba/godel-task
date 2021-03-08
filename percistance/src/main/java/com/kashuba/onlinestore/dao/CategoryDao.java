package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> createCategory(Category category, Integer... idValue);

    List<Category> deleteCategory(int idCategory);

    List<Category> findCategories();
}
