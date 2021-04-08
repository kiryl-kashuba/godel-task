package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;

import java.util.List;

public interface InstanceProductService {
//    InstanceProduct updateInstanceProduct(InstanceProductDto instanceProductDto, int idOfProduct);

    InstanceProduct createInstanceProduct(InstanceProductDto instanceProductDto);

    void deleteInstanceProduct(InstanceProduct instanceProduct);

    List<InstanceProduct> findInstanceProducts();

}
