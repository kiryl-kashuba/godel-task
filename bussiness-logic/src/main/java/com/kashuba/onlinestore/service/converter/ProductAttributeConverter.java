package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeConverter {

    public ProductAttribute toModel(ProductAttributeDto productAttributeDto) {
        ProductAttribute productAttribute = new ProductAttribute(productAttributeDto.getName(),
                productAttributeDto.isMandatory(), productAttributeDto.getType());
        Category category = new Category();
        category.setId(productAttributeDto.getIdOfCategory());
        productAttribute.setCategory(category);
        return productAttribute;
    }

    public ProductAttributeDto toDto(ProductAttribute productAttribute) {
        return new ProductAttributeDto();
    }
}
