package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.impl.CategoryServiceImpl;

public class FindCategoryByIdCommand {

    private static FindCategoryByIdCommand instance;
    private CategoryServiceImpl categoryService = CategoryServiceImpl.getInstance();

    private FindCategoryByIdCommand() {
    }

    public static FindCategoryByIdCommand getInstance() {
        if (instance == null) {
            instance = new FindCategoryByIdCommand();
        }
        return instance;
    }


    public Category findCategories(int id) {
        return categoryService.findCategoryById(id);
    }

}
