package com.kashuba.onlinestore.dao.impl;

public class ProductAttributeValueDaoImpl {

    private static ProductAttributeValueDaoImpl instance;

    private ProductAttributeValueDaoImpl() {
    }

    public static ProductAttributeValueDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeValueDaoImpl();
        }
        return instance;
    }
}
