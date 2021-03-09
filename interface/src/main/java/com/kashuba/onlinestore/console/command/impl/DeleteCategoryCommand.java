package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.impl.CategoryServiceImpl;

import java.util.List;

public class DeleteCategoryCommand {

    private static DeleteCategoryCommand instance;

    private DeleteCategoryCommand() {
    }

    public static DeleteCategoryCommand getInstance() {
        if (instance == null) {
            instance = new DeleteCategoryCommand();
        }
        return instance;
    }

    CategoryServiceImpl categoryService = CategoryServiceImpl.getInstance();

    public List<Category> deleteCategory(int idCategory) {
        return categoryService.deleteCategory(idCategory);
    }
}
