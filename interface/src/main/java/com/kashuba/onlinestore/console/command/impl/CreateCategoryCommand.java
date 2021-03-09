package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.impl.CategoryServiceImpl;

import java.util.List;

public class CreateCategoryCommand {

    private static CreateCategoryCommand instance;

    private CreateCategoryCommand() {
    }

    public static CreateCategoryCommand getInstance() {
        if (instance == null) {
            instance = new CreateCategoryCommand();
        }
        return instance;
    }

    CategoryServiceImpl categoryService = CategoryServiceImpl.getInstance();

    public List<Category> createCLient(Category category, Integer... idValue) {
        return categoryService.createCategory(category, idValue);
    }
}
