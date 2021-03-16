package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.ProductAttributeDao;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public class ProductAttributeDaoImpl extends AbstractCRUDDao<ProductAttribute> implements ProductAttributeDao {

    private static ProductAttributeDaoImpl instance;
    private static final String ADD_CATEGORY = "INSERT INTO categories(name)VALUES (?)";
    private static final String REMOVE_CART = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_ALL_CLIENTS = FIND_ALL + " WHERE role = 1";

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
