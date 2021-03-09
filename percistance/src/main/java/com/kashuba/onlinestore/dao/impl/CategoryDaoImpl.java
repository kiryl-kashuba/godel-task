package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.CategoryDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private FileInitialization fileInitialization = FileInitialization.getInstance();

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
    public List<Category> create(Category category, Integer... idValue) {
        List<ProductAttribute> list = new ArrayList<>();
        for (int i = 0; i < idValue.length; i++) {
            for (ProductAttribute productAttribute : fileInitialization.getReadedPA()) {
                if (idValue[i] == productAttribute.getId()) {
                    list.add(productAttribute);
                }
            }
        }
        category.setProductAttribute(list);
        category.setId(IdGenerator.createID());
        fileInitialization.getReadedCategory().add(category);
        return fileInitialization.getReadedCategory();
    }

    @Override
    public List<Category> delete(int id) {
        fileInitialization.getReadedCategory().removeIf(x -> x.getId() == id);
        return fileInitialization.getReadedCategory();
    }

    @Override
    public List<Category> find() {
        return fileInitialization.getReadedCategory();
    }
}
