package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.impl.ProductAttributeValueServiceImpl;

import java.util.List;

public class DeleteProductAttributeValueCommand {

    private static DeleteProductAttributeValueCommand instance;
    private ProductAttributeValueServiceImpl productAttributeValueService = ProductAttributeValueServiceImpl.getInstance();

    private DeleteProductAttributeValueCommand() {
    }

    public static DeleteProductAttributeValueCommand getInstance() {
        if (instance == null) {
            instance = new DeleteProductAttributeValueCommand();
        }
        return instance;
    }


    public List<ProductAttributeValue> deleteProductAttributeValue(int idProductAttributeValue) {
        return productAttributeValueService.deleteProductAttributeValue(idProductAttributeValue);
    }
}
