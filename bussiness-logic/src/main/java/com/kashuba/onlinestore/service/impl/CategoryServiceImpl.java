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

    CategoryDaoImpl categoryDao = CategoryDaoImpl.getInstance();

    @Override
    public List<Category> createCategory(Category category, Integer... idValue) {
        return categoryDao.createCategory(category, idValue);
    }

    @Override
    public List<Category> deleteCategory(int idCategory) {
        return categoryDao.deleteCategory(idCategory);
    }

    @Override
    public List<Category> findCategories() {
        return categoryDao.findCategories();
    }
}
