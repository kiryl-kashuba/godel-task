package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
import org.springframework.stereotype.Component;

@Component
public class InstanceProductConverter {

    public InstanceProduct toModel(InstanceProductDto instanceProductDto) {
        InstanceProduct instanceProduct = new InstanceProduct(instanceProductDto.getName(),
                instanceProductDto.getArticulation(), instanceProductDto.getPrice());
        Category category = new Category();
        category.setId(instanceProductDto.getIdOfCategory());
        instanceProduct.setCategory(category);
        return instanceProduct;
    }

    public InstanceProductDto toDto(InstanceProduct InstanceProduct) {
        return new InstanceProductDto();
    }
}
