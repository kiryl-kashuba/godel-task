package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.impl.CategoryServiceImpl;

import java.util.List;

public class FindCategoryCommand {

    private static FindCategoryCommand instance;

    private FindCategoryCommand() {
    }

    public static FindCategoryCommand getInstance() {
        if (instance == null) {
            instance = new FindCategoryCommand();
        }
        return instance;
    }

    CategoryServiceImpl categoryService = CategoryServiceImpl.getInstance();

    public List<Category> findCategories() {
        return categoryService.findCategories();
    }

}
