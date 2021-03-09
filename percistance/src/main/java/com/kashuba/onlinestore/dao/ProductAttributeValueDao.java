package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.ProductAttributeValue;

import java.util.List;

public interface ProductAttributeValueDao {

    ProductAttributeValue create(ProductAttributeValue productAttributeValue);

    List<ProductAttributeValue> delete(int id);

    List<ProductAttributeValue> find();
}
