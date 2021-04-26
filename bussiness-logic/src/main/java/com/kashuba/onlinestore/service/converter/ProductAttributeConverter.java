package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.dao.CategoryRepository;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductAttributeConverter {

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductAttribute toModel(ProductAttributeDto productAttributeDto) {
        ProductAttribute productAttribute = new ProductAttribute(productAttributeDto.getName(),
                productAttributeDto.isMandatory(), productAttributeDto.getType());
        Category category = categoryRepository.findById(productAttributeDto.getIdOfCategory()).get();
        productAttribute.setCategory(category);
        return productAttribute;
    }

    public ProductAttributeDto toDto(ProductAttribute productAttribute) {
        return new ProductAttributeDto(productAttribute.getName(), productAttribute.getType(),
                productAttribute.isMandatory());
    }

    public Optional<ProductAttributeDto> toOptionalDto(Optional<ProductAttribute> productAttribute) {
        ProductAttributeDto productAttributeDto = new ProductAttributeDto(productAttribute.get().getName(),
                productAttribute.get().getType(), productAttribute.get().isMandatory());
        return Optional.of(productAttributeDto);
    }

    public List<ProductAttributeDto> toListDto(List<ProductAttribute> productAttributeList) {
        List<ProductAttributeDto> productAttributeDtos = new ArrayList<>();
        for (ProductAttribute productAttribute : productAttributeList) {
            productAttributeDtos.add(new ProductAttributeDto(productAttribute.getName(), productAttribute.getType(),
                    productAttribute.isMandatory()));
        }
        return productAttributeDtos;
    }
}
