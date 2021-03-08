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


    @Override
    public List<InstanceProduct> createInstanceProduct(InstanceProduct instanceProduct) {
        return InstanceProductDaoImpl.getInstance().createInstanceProduct(instanceProduct);
    }

    @Override
    public List<InstanceProduct> updateInstanceProduct(InstanceProduct instanceProduct, int idOfProduct) {
        return InstanceProductDaoImpl.getInstance().updateInstanceProduct(idOfProduct, instanceProduct);
    }

    @Override
    public List<InstanceProduct> deleteInstanceProduct(int idInstanceProduct) {
        return InstanceProductDaoImpl.getInstance().deleteInstanceProduct(idInstanceProduct);
    }

    @Override
    public List<InstanceProduct> findInstanceProducts() {
        return InstanceProductDaoImpl.getInstance().findInstanceProducts();
    }
}
