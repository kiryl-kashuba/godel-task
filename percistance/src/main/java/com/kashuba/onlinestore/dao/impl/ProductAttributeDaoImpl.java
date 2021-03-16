package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.ProductAttributeDao;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public class ProductAttributeDaoImpl extends AbstractCRUDDao<ProductAttribute> implements ProductAttributeDao {

    private static ProductAttributeDaoImpl instance;

    private ProductAttributeDaoImpl() {
    }

    public static ProductAttributeDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeDaoImpl();
        }
        return instance;
    }

    @Override
    public ProductAttribute create(ProductAttribute productAttribute) {

        return productAttribute;
    }

    @Override
    public List<ProductAttribute> delete(int id) {
        return null;
    }

    @Override
    public List<ProductAttribute> find() {
        return null;
    }
}
