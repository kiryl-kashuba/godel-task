package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.CategoryDaoImpl;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDaoImpl categoryDao = CategoryDaoImpl.getInstance();

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
        return categoryDao.create(category, idValue);
    }

    @Override
    public List<Category> deleteCategory(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public List<Category> findCategories() {
        return categoryDao.find();
    }
}
