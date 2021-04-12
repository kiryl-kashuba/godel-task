package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.InstanceProductRepository;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.InstanceProductService;
import com.kashuba.onlinestore.service.converter.InstanceProductConverter;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstanceProductServiceImpl implements InstanceProductService {
    InstanceProductConverter instanceProductConverter = new InstanceProductConverter();
    @Autowired
    private InstanceProductRepository instanceProductRepository;

    @Override
    public InstanceProduct createInstanceProduct(InstanceProductDto instanceProductDto) {
        InstanceProduct instanceProduct = instanceProductConverter.toModel(instanceProductDto);
        return instanceProductRepository.saveAndFlush(instanceProduct);
    }

    @Override
    public void deleteInstanceProduct(InstanceProduct instanceProduct) {
        instanceProductRepository.delete(instanceProduct);
    }

    @Override
    public List<InstanceProduct> findInstanceProducts() {
        return instanceProductRepository.findAll();
    }
}
