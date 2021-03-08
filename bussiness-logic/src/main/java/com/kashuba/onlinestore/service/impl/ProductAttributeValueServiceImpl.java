package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.ProductAttributeValueService;

import java.util.List;

public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {

    private static ProductAttributeValueServiceImpl instance;

    private ProductAttributeValueServiceImpl() {
    }

    public static ProductAttributeValueServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeValueServiceImpl();
        }
        return instance;
    }

    @Override
    public ProductAttributeValue createProductAttributeValue(String value) {
        return null;
    }

    @Override
    public List<ProductAttributeValue> deleteProductAttributeValue(int idAttributeValue) {
        return null;
    }

    @Override
    public List<ProductAttributeValue> findProductAttributeValues() {
        return null;
    }
}
