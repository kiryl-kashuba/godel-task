package com.kashuba.onlinestore.console.command.impl;

public class CreateProductAttributeValueCommand {

    private static CreateProductAttributeValueCommand instance;

    private CreateProductAttributeValueCommand() {
    }

    public static CreateProductAttributeValueCommand getInstance() {
        if (instance == null) {
            instance = new CreateProductAttributeValueCommand();
        }
        return instance;
    }
}
