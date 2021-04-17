package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.dto.ProductAttributeValueDto;

import java.util.List;
import java.util.Optional;

public interface ProductAttributeValueService {

    ProductAttributeValue createProductAttributeValue(ProductAttributeValueDto productAttributeValueDto);

    void deleteProductAttributeValue(Long id);

    List<ProductAttributeValue> findProductAttributeValues();

    Optional<ProductAttributeValue> findById(Long id);
}
