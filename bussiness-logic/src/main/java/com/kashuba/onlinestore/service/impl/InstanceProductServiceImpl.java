package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.InstanceProductRepository;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.InstanceProductService;
import com.kashuba.onlinestore.service.converter.InstanceProductConverter;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InstanceProductServiceImpl implements InstanceProductService {
    InstanceProductConverter instanceProductConverter = new InstanceProductConverter();
    @Autowired
    private InstanceProductRepository instanceProductRepository;
//    @Autowired
//    private CategoryRepository categoryRepository;

    @Override
    public InstanceProduct createInstanceProduct(InstanceProductDto instanceProductDto) {
        InstanceProduct instanceProduct = instanceProductConverter.toModel(instanceProductDto);
        return instanceProductRepository.saveAndFlush(instanceProduct);
    }

    @Override
    public void deleteById(Long id) {
        instanceProductRepository.deleteById(id);
    }

    @Override
    public List<InstanceProduct> findInstanceProducts() {
        return instanceProductRepository.findAll();
    }

    public Optional<InstanceProduct> findById(Long id) {
        return instanceProductRepository.findById(id);
    }

}
