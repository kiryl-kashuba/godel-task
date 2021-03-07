package com.kashuba.onlinestore.console.command.impl;

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
}
