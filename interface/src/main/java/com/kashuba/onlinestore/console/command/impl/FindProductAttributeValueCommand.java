package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.impl.ProductAttributeValueServiceImpl;

import java.util.List;

public class FindProductAttributeValueCommand {

    private static FindProductAttributeValueCommand instance;
    private ProductAttributeValueServiceImpl productAttributeValueService = ProductAttributeValueServiceImpl.getInstance();

    private FindProductAttributeValueCommand() {
    }

    public static FindProductAttributeValueCommand getInstance() {
        if (instance == null) {
            instance = new FindProductAttributeValueCommand();
        }
        return instance;
    }


    public List<ProductAttributeValue> findProductAttributeValue() {
        return productAttributeValueService.findProductAttributeValues();
    }

}
