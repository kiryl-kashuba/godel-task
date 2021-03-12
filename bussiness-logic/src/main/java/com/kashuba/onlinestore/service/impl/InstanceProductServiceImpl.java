package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.InstanceProductDaoImpl;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.InstanceProductService;

import java.util.List;

public class InstanceProductServiceImpl implements InstanceProductService {

    private InstanceProductDaoImpl instanceProductDao = InstanceProductDaoImpl.getInstance();

    private static InstanceProductServiceImpl instance;

    private InstanceProductServiceImpl() {
    }

    public static InstanceProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new InstanceProductServiceImpl();
        }
        return instance;
    }

    @Override
    public InstanceProduct createInstanceProduct(InstanceProduct instanceProduct) {
        return instanceProductDao.create(instanceProduct);
    }

    @Override
    public List<InstanceProduct> updateInstanceProduct(InstanceProduct instanceProduct, int idOfProduct) {
        return instanceProductDao.update(idOfProduct, instanceProduct);
    }

    @Override
    public List<InstanceProduct> deleteInstanceProduct(int id) {
        return instanceProductDao.delete(id);
    }

    @Override
    public List<InstanceProduct> findInstanceProducts() {
        return instanceProductDao.find();
    }
}
