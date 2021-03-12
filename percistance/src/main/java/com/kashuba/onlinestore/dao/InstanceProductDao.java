package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

public interface InstanceProductDao {

    List<InstanceProduct> update(int id, InstanceProduct instanceProduct);

}
