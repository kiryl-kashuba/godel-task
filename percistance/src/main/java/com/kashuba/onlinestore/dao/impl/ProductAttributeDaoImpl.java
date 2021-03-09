package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ProductAttributeDao;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public class ProductAttributeDaoImpl extends FileInitializationHolder implements ProductAttributeDao {

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
    public List<ProductAttribute> create(ProductAttribute productAttribute) {
        productAttribute.setId(IdGenerator.createID());
        fileInitialization.getReadedPA().add(productAttribute);
        return fileInitialization.getReadedPA();
    }

    @Override
    public List<ProductAttribute> delete(int id) {
        fileInitialization.getReadedPA().removeIf(x -> x.getId() == id);
        return fileInitialization.getReadedPA();
    }

    @Override
    public List<ProductAttribute> find() {
        return fileInitialization.getReadedPA();
    }
}
