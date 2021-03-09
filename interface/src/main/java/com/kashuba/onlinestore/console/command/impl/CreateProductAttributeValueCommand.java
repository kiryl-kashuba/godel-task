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

    ProductAttributeValueServiceImpl productAttributeValueService = ProductAttributeValueServiceImpl.getInstance();

    public ProductAttributeValue createProductAttribute(ProductAttributeValue productAttributeValue) {
        return productAttributeValueService.createProductAttributeValue(productAttributeValue);
    }
}
