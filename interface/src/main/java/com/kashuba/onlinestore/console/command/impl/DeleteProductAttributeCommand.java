package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.impl.ProductAttributeServiceImpl;

import java.util.List;

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

    public List<ProductAttribute> DeleteProductAttribute(int idProductAttribute) {
        return ProductAttributeServiceImpl.getInstance().deleteProductAttribute(idProductAttribute);
    }
}
