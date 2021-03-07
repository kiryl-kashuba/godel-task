package com.kashuba.onlinestore.console.command.impl;

public class DeleteProductAttributeCommand {

    private static DeleteProductAttributeCommand instance;

    private DeleteProductAttributeCommand() {
    }

    public static DeleteProductAttributeCommand getInstance() {
        if (instance == null) {
            instance = new DeleteProductAttributeCommand();
        }
        return instance;
    }
}
