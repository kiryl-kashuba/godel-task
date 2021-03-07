package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.entity.InstanceProduct;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InstanceProductService {

    InstanceProduct add(InstanceProduct instanceProduct);

    InstanceProduct updateInstanceProduct(InstanceProduct InstanceProduct);

    InstanceProduct removeInstanceProduct(InstanceProduct InstanceProduct);

    InstanceProduct findInstanceProducts(InstanceProduct InstanceProduct);

    InstanceProduct updateInstanceProductStatus(InstanceProduct updatingInstanceProduct, String statusData);

    List<InstanceProduct> findInstanceProductsById(String InstanceProductIdData);

    Optional<InstanceProduct> findInstanceProductById(long instanceProductId) ;

    List<InstanceProduct> findInstanceProductsByParameters(Map<String, String> instanceProductParametersData) ;


}
