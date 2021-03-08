package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.ProductAttributeDao;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

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
    public List<ProductAttribute> createProductAttribute(ProductAttribute productAttribute) {
        return null;
    }

    @Override
    public List<ProductAttribute> deleteProductAttribute(int idAttribute) {
        return null;
    }

    @Override
    public List<ProductAttribute> findProductAttributes() {
        return null;
    }
}
