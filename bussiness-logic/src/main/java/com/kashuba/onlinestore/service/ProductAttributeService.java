package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;

import java.util.List;

public interface ProductAttributeService {

    ProductAttribute createProductAttribute(ProductAttributeDto productAttributeDto);

    void deleteProductAttribute(int idAttribute);

    List<ProductAttribute> findProductAttributes();
}
