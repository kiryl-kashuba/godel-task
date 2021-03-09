package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public interface ProductAttributeDao {

    List<ProductAttribute> create(ProductAttribute ProductAttribute);

    List<ProductAttribute> delete(int id);

    List<ProductAttribute> find();
}
