package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ProductAttributeValueDao;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public class ProductAttributeDaoImpl extends AbstractCRUDDao implements ProductAttributeValueDao {

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
    public ProductAttribute create(ProductAttribute productAttribute) {
        productAttribute.setId(IdGenerator.createID());
        fileInitialization.getReadedPA().add(productAttribute);
        return productAttribute;
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
