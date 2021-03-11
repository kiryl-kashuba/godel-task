package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.entity.BaseEntity;
import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

public class InstanceProductDaoImpl extends CRUDDao {

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
    public List<InstanceProduct> create(BaseEntity object) {
        object.setId(IdGenerator.createID());
        fileInitialization.getReadedProduct().add((InstanceProduct) object);
        return fileInitialization.getReadedProduct();
    }

    @Override
    public List<InstanceProduct> find() {
        return fileInitialization.getReadedProduct();
    }

    public List<InstanceProduct> update(int id, InstanceProduct instanceProduct) {
        for (InstanceProduct oldInstanceProduct : fileInitialization.getReadedProduct())
            if (id == oldInstanceProduct.getId()) {
                oldInstanceProduct.setPrice(instanceProduct.getPrice());
                oldInstanceProduct.setArticulation(instanceProduct.getArticulation());
                oldInstanceProduct.setName(instanceProduct.getName());
                oldInstanceProduct.setProductAttributeValue(instanceProduct.getProductAttributeValue());
                oldInstanceProduct.setCategory(instanceProduct.getCategory());
            }
        return fileInitialization.getReadedProduct();
    }

    @Override
    public List<InstanceProduct> delete(int idInstanceProduct) {
        fileInitialization.getReadedProduct().removeIf(x -> x.getId() == idInstanceProduct);
        return fileInitialization.getReadedProduct();
    }
}
