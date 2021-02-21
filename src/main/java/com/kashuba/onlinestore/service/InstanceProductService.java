package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.exeption.ServiceProjectException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InstanceProductService {

    boolean add(Map<String, String> productParameters) throws ServiceProjectException;

    Optional<InstanceProduct> findInstanceProductById(long instanceProductId) throws ServiceProjectException;

    boolean updateInstanceProduct(/** */) throws ServiceProjectException;

    List<InstanceProduct> findInstanceProductsByParameters(Map<String, String> instanceProductParametersData) throws ServiceProjectException;


}
