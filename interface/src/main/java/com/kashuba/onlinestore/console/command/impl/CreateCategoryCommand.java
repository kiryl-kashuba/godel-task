package com.kashuba.onlinestore.console.command.impl;

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
}
