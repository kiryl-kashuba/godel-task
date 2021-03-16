package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.InstanceProductDao;
import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

public class InstanceProductDaoImpl extends AbstractCRUDDao<InstanceProduct> implements InstanceProductDao {

    private static InstanceProductDaoImpl instance;
    private static final String ADD_CATEGORY = "INSERT INTO categories(name)VALUES (?)";
    private static final String REMOVE_CART = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_ALL_CLIENTS = FIND_ALL + " WHERE role = 1";

    private InstanceProductDaoImpl() {
    }

    public static InstanceProductDaoImpl getInstance() {
        if (instance == null) {
            instance = new InstanceProductDaoImpl();
        }
        return instance;
    }

    @Override
    public InstanceProduct create(InstanceProduct instanceProduct) {
        instanceProduct.setId(IdGenerator.createID());
        return instanceProduct;
    }

    @Override
    public List<InstanceProduct> find() {
        return null;
    }

    public List<InstanceProduct> update(int id, InstanceProduct instanceProduct) {

        return null;
    }

    @Override
    public List<InstanceProduct> delete(int idInstanceProduct) {
        return null;
    }
}
