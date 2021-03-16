package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ProductAttributeValueDao;
import com.kashuba.onlinestore.entity.ProductAttributeValue;

import java.util.List;

public class ProductAttributeValueDaoImpl extends AbstractCRUDDao<ProductAttributeValue> implements ProductAttributeValueDao {

    private static ProductAttributeValueDaoImpl instance;
    private static final String ADD_CATEGORY = "INSERT INTO categories(name)VALUES (?)";
    private static final String REMOVE_CART = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_ALL_CLIENTS = FIND_ALL + " WHERE role = 1";

    private ProductAttributeValueDaoImpl() {
    }

    public static ProductAttributeValueDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeValueDaoImpl();
        }
        return instance;
    }

    @Override
    public ProductAttributeValue create(ProductAttributeValue productAttributeValue) {
        productAttributeValue.setId(IdGenerator.createID());
        return productAttributeValue;
    }

    @Override
    public List<ProductAttributeValue> delete(int id) {
        return null;
    }

    @Override
    public List<ProductAttributeValue> find() {
        return null;
    }
}
