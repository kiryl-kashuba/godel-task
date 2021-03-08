package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.CategoryDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private static CategoryDaoImpl instance;

    private CategoryDaoImpl() {
    }

    public static CategoryDaoImpl getInstance() {
        if (instance == null) {
            instance = new CategoryDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Category> createCategory(Category category, Integer... idValue) {
        List<ProductAttribute> list = new ArrayList<>();
        for (int i = 0; i < idValue.length; i++) {
            for (ProductAttribute productAttribute : FileInitialization.getInstance().getReadedPA()) {
                if (idValue[i] == productAttribute.getId()) {
                    list.add(productAttribute);
                }
            }
        }
        category.setProductAttribute(list);
        category.setId(IdGenerator.createID());
        FileInitialization.getInstance().getReadedCategory().add(category);
        return FileInitialization.getInstance().getReadedCategory();
    }

    @Override
    public List<Category> deleteCategory(int idCategory) {
        FileInitialization.getInstance().getReadedCategory().removeIf(x -> x.getId() == idCategory);
        return FileInitialization.getInstance().getReadedCategory();
    }

    @Override
    public List<Category> findCategories() {
        return null;
    }
}
