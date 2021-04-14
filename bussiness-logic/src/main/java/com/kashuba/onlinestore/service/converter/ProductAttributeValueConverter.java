package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.dto.ProductAttributeValueDto;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeValueConverter {

    public ProductAttributeValue toModel(ProductAttributeValueDto productAttributeValueDto) {
        return new ProductAttributeValue(productAttributeValueDto.getValue());
    }

    public ProductAttributeValueDto toDto(ProductAttributeValue productAttributeValue) {
        return new ProductAttributeValueDto();
    }
}
