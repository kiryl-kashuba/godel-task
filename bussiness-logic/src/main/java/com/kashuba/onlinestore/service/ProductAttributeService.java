package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.List;

public interface ProductAttributeService {

    ProductAttribute createProductAttribute(ProductAttribute productAttribute);

    List<ProductAttribute> deleteProductAttribute(int idAttribute);

    List<ProductAttribute> findProductAttributes();
}
