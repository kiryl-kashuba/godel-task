package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.CategoryDao;
import com.kashuba.onlinestore.entity.Category;

import java.util.List;

public class CategoryDaoImpl extends AbstractCRUDDao implements CategoryDao {

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
    public Category create(Category category) {
        category.setId(IdGenerator.createID());
        fileInitialization.getReadedCategory().add(category);
        return category;
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
