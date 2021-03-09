package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.ProductAttributeValueDaoImpl;
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

    ProductAttributeValueDaoImpl productAttributeValueDao = ProductAttributeValueDaoImpl.getInstance();

    @Override
    public ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue) {
        return productAttributeValueDao.createProductAttributeValue(productAttributeValue);
    }

    @Override
    public List<ProductAttributeValue> deleteProductAttributeValue(int idAttributeValue) {
        return productAttributeValueDao.findProductAttributeValues();
    }

    @Override
    public List<ProductAttributeValue> findProductAttributeValues() {
        return productAttributeValueDao.findProductAttributeValues();
    }
}
