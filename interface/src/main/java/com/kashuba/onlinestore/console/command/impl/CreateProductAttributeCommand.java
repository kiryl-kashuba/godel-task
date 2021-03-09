package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.impl.ProductAttributeServiceImpl;

import java.util.List;

public class CreateProductAttributeCommand {

    private static CreateProductAttributeCommand instance;
    private ProductAttributeServiceImpl productAttributeService = ProductAttributeServiceImpl.getInstance();

    private CreateProductAttributeCommand() {
    }

    public static CreateProductAttributeCommand getInstance() {
        if (instance == null) {
            instance = new CreateProductAttributeCommand();
        }
        return instance;
    }


    public List<ProductAttribute> createProductAttribute(ProductAttribute productAttribute) {
        return productAttributeService.createProductAttribute(productAttribute);
    }
}
