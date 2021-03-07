package com.kashuba.onlinestore.console.command.impl;

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
}
