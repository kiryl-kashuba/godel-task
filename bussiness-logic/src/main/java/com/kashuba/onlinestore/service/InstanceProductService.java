package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.dto.InstanceProductDto;

public interface InstanceProductService extends Crud<InstanceProductDto> {

    InstanceProductDto addToCart(InstanceProductDto instanceProductDto);
}
