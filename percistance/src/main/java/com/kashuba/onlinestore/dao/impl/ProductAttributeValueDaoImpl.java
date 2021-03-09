package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ProductAttributeValueDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.ProductAttributeValue;

import java.util.List;

public class ProductAttributeValueDaoImpl implements ProductAttributeValueDao {

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
    public ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue) {
        productAttributeValue.setId(IdGenerator.createID());
        FileInitialization.getInstance().getReadedPAV().add(productAttributeValue);
        return productAttributeValue;
    }

    @Override
    public List<ProductAttributeValue> deleteProductAttributeValue(int idAttribute) {
        FileInitialization.getInstance().getReadedPAV().removeIf(x -> x.getId() == idAttribute);
        return FileInitialization.getInstance().getReadedPAV();
    }

    @Override
    public List<ProductAttributeValue> findProductAttributeValues() {
        return FileInitialization.getInstance().getReadedPAV();
    }
}
