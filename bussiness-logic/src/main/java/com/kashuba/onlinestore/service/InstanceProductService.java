package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

public interface InstanceProductService {

    List<InstanceProduct> createInstanceProduct(InstanceProduct instanceProduct);

    List<InstanceProduct> updateInstanceProduct(InstanceProduct instanceProduct, int idOfProduct);

    List<InstanceProduct> deleteInstanceProduct(int idInstanceProduct);

    List<InstanceProduct> findInstanceProducts();


}
