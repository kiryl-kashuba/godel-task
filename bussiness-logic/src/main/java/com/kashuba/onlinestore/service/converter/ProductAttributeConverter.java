package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeConverter {

    public ProductAttribute toModel(ProductAttributeDto productAttributeDto) {
        return new ProductAttribute(productAttributeDto.getName(), productAttributeDto.isMandatory(), productAttributeDto.getType());
    }

    public ProductAttributeDto toDto(ProductAttribute productAttribute) {
        return new ProductAttributeDto();
    }
}
