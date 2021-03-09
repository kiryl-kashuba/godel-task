package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public interface ProductAttributeDao {

    List<ProductAttribute> createProductAttribute(ProductAttribute ProductAttribute);

    List<ProductAttribute> deleteProductAttribute(int idAttributeValue);

    List<ProductAttribute> findProductAttributes();
}
