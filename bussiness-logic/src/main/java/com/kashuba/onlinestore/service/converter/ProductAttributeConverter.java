package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.dao.CategoryRepository;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductAttributeConverter {

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductAttribute toModel(ProductAttributeDto productAttributeDto) {
        ProductAttribute productAttribute = new ProductAttribute(productAttributeDto.getName(),
                productAttributeDto.isMandatory(), productAttributeDto.getType());
        Category category = categoryRepository.findById(productAttributeDto.getIdOfCategory()).get();
        category.setId(productAttributeDto.getIdOfCategory());
        ArrayList<ProductAttribute> objects = new ArrayList<>();
        objects.add(productAttribute);
        category.setProductAttribute(objects);
        categoryRepository.saveAndFlush(category);
        productAttribute.setCategory(category);
        return productAttribute;
    }

    public ProductAttributeDto toDto(ProductAttribute productAttribute) {
        return new ProductAttributeDto();
    }
}
