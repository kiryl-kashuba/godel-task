package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.ProductAttributeValue;

import java.util.List;

public interface ProductAttributeValueDao {

    ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue);

    List<ProductAttributeValue> deleteProductAttributeValue(int idProductAttributeValue);

    List<ProductAttributeValue> findProductAttributeValues();
}
