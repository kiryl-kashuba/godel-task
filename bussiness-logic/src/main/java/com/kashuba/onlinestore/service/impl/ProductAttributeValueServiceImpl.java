package com.kashuba.onlinestore.service.impl;

public class ProductAttributeValueServiceImpl {

    private static ProductAttributeValueServiceImpl instance;

    private ProductAttributeValueServiceImpl() {
    }

    public static ProductAttributeValueServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeValueServiceImpl();
        }
        return instance;
    }
}
