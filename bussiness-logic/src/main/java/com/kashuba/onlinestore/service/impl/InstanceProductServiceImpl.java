package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.InstanceProductDaoImpl;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.InstanceProductService;

import java.util.List;

public class InstanceProductServiceImpl implements InstanceProductService {

    private static InstanceProductServiceImpl instance;

    private InstanceProductServiceImpl() {
    }

    public static InstanceProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new InstanceProductServiceImpl();
        }
        return instance;
    }

    InstanceProductDaoImpl instanceProductDao = InstanceProductDaoImpl.getInstance();

    @Override
    public List<InstanceProduct> createInstanceProduct(InstanceProduct instanceProduct) {
        return instanceProductDao.createInstanceProduct(instanceProduct);
    }

    @Override
    public List<InstanceProduct> updateInstanceProduct(InstanceProduct instanceProduct, int idOfProduct) {
        return instanceProductDao.updateInstanceProduct(idOfProduct, instanceProduct);
    }

    @Override
    public List<InstanceProduct> deleteInstanceProduct(int idInstanceProduct) {
        return instanceProductDao.deleteInstanceProduct(idInstanceProduct);
    }

    @Override
    public List<InstanceProduct> findInstanceProducts() {
        return instanceProductDao.findInstanceProducts();
    }
}
