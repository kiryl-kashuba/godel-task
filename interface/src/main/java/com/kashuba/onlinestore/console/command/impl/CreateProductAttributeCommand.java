package com.kashuba.onlinestore.console.command.impl;

public class CreateProductAttributeCommand {

    private static CreateProductAttributeCommand instance;

    private CreateProductAttributeCommand() {
    }

    public static CreateProductAttributeCommand getInstance() {
        if (instance == null) {
            instance = new CreateProductAttributeCommand();
        }
        return instance;
    }
}
