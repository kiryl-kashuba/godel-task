package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.converter.ProductAttributeConverter;
import com.kashuba.onlinestore.dao.ProductAttributeRepository;
import com.kashuba.onlinestore.dto.ProductAttributeDto;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.ProductAttributeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductAttributeServiceImpl implements ProductAttributeService {
    @Autowired
    private ProductAttributeConverter productAttributeConverter;

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Override
    public ProductAttributeDto create(ProductAttributeDto productAttributeDto) {
        ProductAttribute productAttribute = productAttributeConverter.toModel(productAttributeDto);
        return productAttributeConverter.toDto(productAttributeRepository.saveAndFlush(productAttribute));
    }

    @Override
    public void deleteById(Long id) {
        productAttributeRepository.deleteById(id);
    }

    @Override
    public List<ProductAttributeDto> findAll() {
        return productAttributeConverter.toListDto(productAttributeRepository.findAll());
    }

    public Optional<ProductAttributeDto> findById(Long id) {
        return productAttributeConverter.toOptionalDto(productAttributeRepository.findById(id));
    }

}
