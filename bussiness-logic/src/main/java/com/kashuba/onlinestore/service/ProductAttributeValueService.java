package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.ProductAttributeValue;

import java.util.List;

public interface ProductAttributeValueService {

    ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue);

    List<ProductAttributeValue> deleteProductAttributeValue(int idAttributeValue);

    List<ProductAttributeValue> findProductAttributeValues();
}
