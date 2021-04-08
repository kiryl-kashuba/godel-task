package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.dto.ProductAttributeValueDto;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeValueConverter {

    public ProductAttributeValue toModel(ProductAttributeValueDto ProductAttributeValueDto) {
        return new ProductAttributeValue();
    }

    public ProductAttributeValueDto toDto(ProductAttributeValue ProductAttributeValue) {
        return new ProductAttributeValueDto();
    }
}
