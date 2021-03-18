package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.CategoryDaoImpl;
import com.kashuba.onlinestore.dao.impl.ProductAttributeDaoImpl;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDaoImpl categoryDao = CategoryDaoImpl.getInstance();
    private ProductAttributeDaoImpl productAttributeDao = ProductAttributeDaoImpl.getInstance();

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
    public Category createCategory(Category category) {

        return categoryDao.create(category);
    }

    @Override
    public List<Category> deleteCategory(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public List<Category> findCategories() {
        List<Category> clientCategory = null;

        try {
            clientCategory = categoryDao.find();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientCategory;
    }

    @Override
    public Category findCategoryById(int idCategory) {
        Category category = null;
        try {
            category = categoryDao.findById(idCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}
