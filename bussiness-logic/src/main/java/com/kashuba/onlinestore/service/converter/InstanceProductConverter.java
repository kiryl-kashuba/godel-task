package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public InstanceProductDto toDto(InstanceProduct instanceProduct) {
        return new InstanceProductDto(instanceProduct.getArticulation(),
                instanceProduct.getPrice(), instanceProduct.getName());
    }

    public Optional<InstanceProductDto> toOptionalDto(Optional<InstanceProduct> instanceProduct) {
        InstanceProductDto instanceProductDto = new InstanceProductDto(instanceProduct.get().getArticulation(),
                instanceProduct.get().getPrice(), instanceProduct.get().getName());
        return Optional.of(instanceProductDto);
    }

    public List<InstanceProductDto> toListDto(List<InstanceProduct> instanceProductList) {
        List<InstanceProductDto> instanceProductDtos = new ArrayList<>();
        for (InstanceProduct instanceProduct : instanceProductList) {
            instanceProductDtos.add(new InstanceProductDto(instanceProduct.getArticulation(),
                    instanceProduct.getPrice(), instanceProduct.getName()));
        }
        return instanceProductDtos;
    }
}
