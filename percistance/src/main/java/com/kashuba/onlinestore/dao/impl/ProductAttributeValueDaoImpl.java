package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ProductAttributeValueDao;
import com.kashuba.onlinestore.entity.ProductAttributeValue;

import java.util.List;

public class ProductAttributeValueDaoImpl extends AbstractCRUDDao implements ProductAttributeValueDao {

    private static ProductAttributeValueDaoImpl instance;

    private ProductAttributeValueDaoImpl() {
    }

    public static ProductAttributeValueDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeValueDaoImpl();
        }
        return instance;
    }

    @Override
    public ProductAttributeValue create(ProductAttributeValue productAttributeValue) {
        productAttributeValue.setId(IdGenerator.createID());
        fileInitialization.getReadedPAV().add(productAttributeValue);
        return productAttributeValue;
    }

    @Override
    public List<ProductAttributeValue> delete(int id) {
        fileInitialization.getReadedPAV().removeIf(x -> x.getId() == id);
        return fileInitialization.getReadedPAV();
    }

    @Override
    public List<ProductAttributeValue> find() {
        return fileInitialization.getReadedPAV();
    }
}
