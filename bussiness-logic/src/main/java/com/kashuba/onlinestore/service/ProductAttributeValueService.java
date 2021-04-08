package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.dto.ProductAttributeValueDto;

import java.util.List;

public interface ProductAttributeValueService {

    ProductAttributeValue createProductAttributeValue(ProductAttributeValueDto productAttributeValueDto);

    void deleteProductAttributeValue(int idAttributeValue);

    List<ProductAttributeValue> findProductAttributeValues();
}
