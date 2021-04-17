package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;

import java.util.List;
import java.util.Optional;

public interface ProductAttributeService {

    ProductAttribute createProductAttribute(ProductAttributeDto productAttributeDto);

    void deleteProductAttribute(Long id);

    List<ProductAttribute> findProductAttributes();

    Optional<ProductAttribute> findById(Long id);
}
