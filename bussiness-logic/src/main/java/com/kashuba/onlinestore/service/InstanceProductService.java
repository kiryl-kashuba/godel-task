package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;

import java.util.List;
import java.util.Optional;

public interface InstanceProductService {
//    InstanceProduct updateInstanceProduct(InstanceProductDto instanceProductDto, int idOfProduct);

    InstanceProduct createInstanceProduct(InstanceProductDto instanceProductDto);

    void deleteById(Long id);

    List<InstanceProduct> findInstanceProducts();

    Optional<InstanceProduct> findById(Long id);

}
