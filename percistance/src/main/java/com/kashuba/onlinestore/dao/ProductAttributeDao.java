package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public interface ProductAttributeDao {

    List<ProductAttribute> createProductAttribute(ProductAttribute productAttribute);

    List<ProductAttribute> deleteProductAttribute(int idAttribute);

    List<ProductAttribute> findProductAttributes();
}
