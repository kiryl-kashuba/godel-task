package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.converter.ProductAttributeValueConverter;
import com.kashuba.onlinestore.dao.ProductAttributeValueRepository;
import com.kashuba.onlinestore.dto.ProductAttributeValueDto;
import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.ProductAttributeValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {

    @Autowired
    private ProductAttributeValueConverter productAttributeValueConverter;

    @Autowired
    private ProductAttributeValueRepository productAttributeValueRepository;

    @Override
    public ProductAttributeValueDto create(ProductAttributeValueDto productAttributeValueDto) {
        ProductAttributeValue productAttributeValue = productAttributeValueConverter.toModel(productAttributeValueDto);
        return productAttributeValueConverter.toDto(productAttributeValueRepository.saveAndFlush(productAttributeValue));
    }

    @Override
    public void deleteById(Long id) {
        productAttributeValueRepository.deleteById(id);
    }

    @Override
    public List<ProductAttributeValueDto> findAll() {
        return productAttributeValueConverter.toListDto(productAttributeValueRepository.findAll());
    }

    public Optional<ProductAttributeValueDto> findById(Long id) {
        return productAttributeValueConverter.toOptionalDto(productAttributeValueRepository.findById(id));
    }
}
