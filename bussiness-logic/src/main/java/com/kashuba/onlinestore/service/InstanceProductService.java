package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;

import java.util.List;

public interface InstanceProductService {

    InstanceProduct createInstanceProduct(InstanceProductDto instanceProductDto);

    InstanceProduct updateInstanceProduct(InstanceProductDto instanceProductDto, int idOfProduct);

    void deleteInstanceProduct(int idInstanceProduct);

    List<InstanceProduct> findInstanceProducts();


}
