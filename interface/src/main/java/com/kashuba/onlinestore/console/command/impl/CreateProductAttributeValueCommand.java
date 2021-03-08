package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.impl.ProductAttributeValueServiceImpl;

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

    public ProductAttributeValue createInstance(String value) {
        return ProductAttributeValueServiceImpl.getInstance().createProductAttributeValue(productAttributeValue);
    }
}
