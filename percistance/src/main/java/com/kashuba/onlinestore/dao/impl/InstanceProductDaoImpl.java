package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.InstanceProductDao;
import com.kashuba.onlinestore.entity.InstanceProduct;

public class InstanceProductDaoImpl implements InstanceProductDao {

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
    public InstanceProduct add(InstanceProduct instanceProduct) {
        return null;
    }
}
