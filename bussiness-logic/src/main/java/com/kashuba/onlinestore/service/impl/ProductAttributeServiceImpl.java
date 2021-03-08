package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.ProductAttributeDaoImpl;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.ProductAttributeService;

import java.util.List;

public class ProductAttributeServiceImpl implements ProductAttributeService {

    private static ProductAttributeServiceImpl instance;

    private ProductAttributeServiceImpl() {
    }

    public static ProductAttributeServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeServiceImpl();
        }
        return instance;
    }

    @Override
    public List<ProductAttribute> createProductAttribute(ProductAttribute productAttribute) {
        return ProductAttributeDaoImpl.getInstance().createProductAttribute(productAttribute);
    }

    @Override
    public List<ProductAttribute> deleteProductAttribute(int idAttribute) {
        return ProductAttributeDaoImpl.getInstance().deleteProductAttribute(idAttribute);
    }

    @Override
    public List<ProductAttribute> findProductAttributes() {
        return ProductAttributeDaoImpl.getInstance().findProductAttributes();
    }
}
