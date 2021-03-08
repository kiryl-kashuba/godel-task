package com.kashuba.onlinestore.service.impl;

public class ProductAttributeServiceImpl {

    private static ProductAttributeServiceImpl instance;

    private ProductAttributeServiceImpl() {
    }

    public static ProductAttributeServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeServiceImpl();
        }
        return instance;
    }
}
