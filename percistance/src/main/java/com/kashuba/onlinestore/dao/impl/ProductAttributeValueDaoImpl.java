package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.ProductAttributeDao;
import com.kashuba.onlinestore.entity.ProductAttributeValue;

public class ProductAttributeValueDaoImpl implements ProductAttributeDao {

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
    public ProductAttributeValue createProductAttribute(String value) {
        return null;
    }

    @Override
    public ProductAttributeValue deleteProductAttribute(int idAttribute) {
        return null;
    }

    @Override
    public ProductAttributeValue findProductAttributes() {
        return null;
    }
}
