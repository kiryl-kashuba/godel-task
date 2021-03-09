package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.impl.ProductAttributeServiceImpl;

import java.util.List;

public class FindProductAttributeCommand {

    private static FindProductAttributeCommand instance;
    private ProductAttributeServiceImpl productAttributeService = ProductAttributeServiceImpl.getInstance();

    private FindProductAttributeCommand() {
    }

    public static FindProductAttributeCommand getInstance() {
        if (instance == null) {
            instance = new FindProductAttributeCommand();
        }
        return instance;
    }


    public List<ProductAttribute> findProductAttributes() {
        return productAttributeService.findProductAttributes();
    }

}
