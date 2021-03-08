package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ProductAttributeDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public class ProductAttributeDaoImpl implements ProductAttributeDao {

    private static ProductAttributeDaoImpl instance;

    private ProductAttributeDaoImpl() {
    }

    public static ProductAttributeDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeDaoImpl();
        }
        return instance;
    }

    @Override
    public List<ProductAttribute> createProductAttribute(ProductAttribute productAttribute) {
        productAttribute.setId(IdGenerator.createID());
        FileInitialization.getInstance().getReadedPA().add(productAttribute);
        return FileInitialization.getInstance().getReadedPA();
    }

    @Override
    public List<ProductAttribute> deleteProductAttribute(int idAttribute) {
        FileInitialization.getInstance().getReadedPA().removeIf(x -> x.getId() == idAttribute);
        return FileInitialization.getInstance().getReadedPA();
    }

    @Override
    public List<ProductAttribute> findProductAttributes() {
        return FileInitialization.getInstance().getReadedPA();
    }
}
