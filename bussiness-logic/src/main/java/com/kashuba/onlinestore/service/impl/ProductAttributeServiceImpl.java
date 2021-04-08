package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.ProductAttributeRepository;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.ProductAttributeService;
import com.kashuba.onlinestore.service.converter.ProductAttributeConverter;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
    ProductAttributeConverter productAttributeConverter = new ProductAttributeConverter();
    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Override
    public ProductAttribute createProductAttribute(ProductAttributeDto productAttributeDto) {
        ProductAttribute productAttribute = productAttributeConverter.toModel(productAttributeDto);
        return productAttributeRepository.saveAndFlush(productAttribute);
    }

    @Override
    public void deleteProductAttribute(ProductAttribute productAttribute) {
        productAttributeRepository.delete(productAttribute);
    }

    @Override
    public List<ProductAttribute> findProductAttributes() {
        return productAttributeRepository.findAll();
    }
}
