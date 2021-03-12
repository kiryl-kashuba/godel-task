package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.impl.CategoryServiceImpl;

public class CreateCategoryCommand {

    private static CreateCategoryCommand instance;
    private CategoryServiceImpl categoryService = CategoryServiceImpl.getInstance();

    private CreateCategoryCommand() {
    }

    public static CreateCategoryCommand getInstance() {
        if (instance == null) {
            instance = new CreateCategoryCommand();
        }
        return instance;
    }


    public Category createCLient(Category category, Integer... idValue) {
        return categoryService.createCategory(category, idValue);
    }
}
