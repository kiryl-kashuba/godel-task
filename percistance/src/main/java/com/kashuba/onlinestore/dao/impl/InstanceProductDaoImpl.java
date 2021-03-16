package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.InstanceProductDao;
import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

public class InstanceProductDaoImpl extends AbstractCRUDDao<InstanceProduct> implements InstanceProductDao {

    private static InstanceProductDaoImpl instance;

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
