package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

public interface InstanceProductDao {

    List<InstanceProduct> createInstanceProduct(InstanceProduct instanceProduct);

    List<InstanceProduct> findInstanceProducts();

    List<InstanceProduct> updateInstanceProduct(int idInstanceProduct, InstanceProduct instanceProduct);

    List<InstanceProduct> deleteInstanceProduct(int idInstanceProduct);
}
