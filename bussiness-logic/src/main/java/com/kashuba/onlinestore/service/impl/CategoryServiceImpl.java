package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.CategoryDaoImpl;
import com.kashuba.onlinestore.dao.impl.ProductAttributeDaoImpl;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.CategoryService;

import java.util.ArrayList;
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
    public Category createCategory(Category category, Integer... idValue) {

        List<ProductAttribute> list = new ArrayList<>();
        for (int i = 0; i < idValue.length; i++) {
            for (ProductAttribute productAttribute : productAttributeDao.find()) {
                if (idValue[i] == productAttribute.getId()) {
                    list.add(productAttribute);
                }
            }
        }
        category.setProductAttribute(list);

        return categoryDao.create(category);
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
