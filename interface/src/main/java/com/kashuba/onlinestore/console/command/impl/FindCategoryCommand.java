package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.impl.CategoryServiceImpl;

import java.util.List;

public class FindCategoryCommand {

    private static FindCategoryCommand instance;
    private CategoryServiceImpl categoryService = CategoryServiceImpl.getInstance();

    private FindCategoryCommand() {
    }

    public static FindCategoryCommand getInstance() {
        if (instance == null) {
            instance = new FindCategoryCommand();
        }
        return instance;
    }


    public List<Category> findCategories() {
        return categoryService.findCategories();
    }

}
