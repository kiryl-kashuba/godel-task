package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.dto.ProductAttributeValueDto;

import java.util.List;
import java.util.Optional;

public interface ProductAttributeValueService {

    ProductAttributeValue create(ProductAttributeValueDto productAttributeValueDto);

    void delete(Long id);

    List<ProductAttributeValue> findAll();

    Optional<ProductAttributeValue> findById(Long id);
}
