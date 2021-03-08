package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.InstanceProductDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

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
    public List<InstanceProduct> createInstanceProduct(InstanceProduct instanceProduct) {
        instanceProduct.setId(IdGenerator.createID());
        FileInitialization.getInstance().getReadedProduct().add(instanceProduct);
        return FileInitialization.getInstance().getReadedProduct();
    }

    @Override
    public List<InstanceProduct> findInstanceProducts() {
        return FileInitialization.getInstance().getReadedProduct();
    }

    @Override
    public List<InstanceProduct> updateInstanceProduct(int idInstanceProduct, InstanceProduct instanceProduct) {
        for (InstanceProduct OldInstanceProduct : FileInitialization.getInstance().getReadedProduct())
            if (idInstanceProduct == OldInstanceProduct.getId()) {
                OldInstanceProduct.setPrice(instanceProduct.getPrice());
                OldInstanceProduct.setArticulation(instanceProduct.getArticulation());
                OldInstanceProduct.setName(instanceProduct.getName());
                OldInstanceProduct.setProductAttributeValue(instanceProduct.getProductAttributeValue());
                OldInstanceProduct.setCategory(instanceProduct.getCategory());
            }
        return FileInitialization.getInstance().getReadedProduct();
    }

    @Override
    public List<InstanceProduct> deleteInstanceProduct(int idInstanceProduct) {
        FileInitialization.getInstance().getReadedProduct().removeIf(x -> x.getId() == idInstanceProduct);
        return FileInitialization.getInstance().getReadedProduct();
    }
}
