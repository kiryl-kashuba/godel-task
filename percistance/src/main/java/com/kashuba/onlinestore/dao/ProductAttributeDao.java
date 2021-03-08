package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.ProductAttributeValue;

public interface ProductAttributeDao {

    ProductAttributeValue createProductAttribute(String value);

    ProductAttributeValue deleteProductAttribute(int idAttribute);

    ProductAttributeValue findProductAttributes();
}
