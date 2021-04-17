package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.ProductAttributeValueRepository;
import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.ProductAttributeValueService;
import com.kashuba.onlinestore.service.converter.ProductAttributeValueConverter;
import com.kashuba.onlinestore.service.dto.ProductAttributeValueDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {
    ProductAttributeValueConverter productAttributeValueConverter = new ProductAttributeValueConverter();
    @Autowired
    private ProductAttributeValueRepository productAttributeValueRepository;

    @Override
    public ProductAttributeValue createProductAttributeValue(ProductAttributeValueDto productAttributeValueDto) {
        ProductAttributeValue productAttributeValue = productAttributeValueConverter.toModel(productAttributeValueDto);
        return productAttributeValueRepository.saveAndFlush(productAttributeValue);
    }

    @Override
    public void deleteProductAttributeValue(Long id) {
        productAttributeValueRepository.deleteById(id);
    }

    @Override
    public List<ProductAttributeValue> findProductAttributeValues() {
        return productAttributeValueRepository.findAll();
    }

    public Optional<ProductAttributeValue> findById(Long id) {
        return productAttributeValueRepository.findById(id);
    }

}
