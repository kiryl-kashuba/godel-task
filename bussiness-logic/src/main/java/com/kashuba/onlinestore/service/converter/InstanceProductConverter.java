package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
import org.springframework.stereotype.Component;

@Component
public class InstanceProductConverter {

    public InstanceProduct toModel(InstanceProductDto instanceProductDto) {
        return new InstanceProduct();
    }

    public InstanceProductDto toDto(InstanceProduct InstanceProduct) {
        return new InstanceProductDto();
    }
}
