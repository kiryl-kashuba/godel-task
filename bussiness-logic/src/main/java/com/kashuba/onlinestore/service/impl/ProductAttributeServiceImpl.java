package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.CategoryRepository;
import com.kashuba.onlinestore.dao.ProductAttributeRepository;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.ProductAttributeService;
import com.kashuba.onlinestore.service.converter.ProductAttributeConverter;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductAttributeServiceImpl implements ProductAttributeService {
    ProductAttributeConverter productAttributeConverter = new ProductAttributeConverter();
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductAttribute createProductAttribute(ProductAttributeDto productAttributeDto) {
        ProductAttribute productAttribute = productAttributeConverter.toModel(productAttributeDto);
        productAttribute.setCategory(categoryRepository.findById(productAttributeDto.getIdOfCategory()).get());
        return productAttributeRepository.saveAndFlush(productAttribute);
    }

    @Override
    public void deleteProductAttribute(Long id) {
        productAttributeRepository.deleteById(id);
    }

    @Override
    public List<ProductAttribute> findProductAttributes() {
        return productAttributeRepository.findAll();
    }

    public Optional<ProductAttribute> findById(Long id) {
        return productAttributeRepository.findById(id);
    }

}
