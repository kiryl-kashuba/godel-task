package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.CategoryDaoImpl;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private static CategoryServiceImpl instance;

    private CategoryServiceImpl() {
    }

    public static CategoryServiceImpl getInstance() {
        if (instance == null) {
            instance = new CategoryServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Category> createCategory(Category category, Integer... idValue) {
        return CategoryDaoImpl.getInstance().createCategory(category, idValue);
    }

    @Override
    public List<Category> deleteCategory(int idCategory) {
        return CategoryDaoImpl.getInstance().deleteCategory(idCategory);
    }

    @Override
    public List<Category> findCategories() {
        return CategoryDaoImpl.getInstance().findCategories();
    }
}
