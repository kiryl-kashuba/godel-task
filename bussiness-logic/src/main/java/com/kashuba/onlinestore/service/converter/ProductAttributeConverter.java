package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeConverter {

    public ProductAttribute toModel(ProductAttributeDto ProductAttributeDto) {
        return new ProductAttribute();
    }

    public ProductAttributeDto toDto(ProductAttribute ProductAttribute) {
        return new ProductAttributeDto();
    }
}
