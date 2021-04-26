package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.*;
import com.kashuba.onlinestore.entity.*;
import com.kashuba.onlinestore.service.InstanceProductService;
import com.kashuba.onlinestore.service.converter.InstanceProductConverter;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class InstanceProductServiceImpl implements InstanceProductService {
    @Autowired
    private InstanceProductConverter instanceProductConverter;
    @Autowired
    private InstanceProductRepository instanceProductRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Autowired
    private ProductAttributeValueRepository productAttributeValueRepository;

    @Override
    public InstanceProductDto create(InstanceProductDto instanceProductDto) {
        InstanceProduct instanceProduct = instanceProductConverter.toModel(instanceProductDto);
        return instanceProductConverter.toDto(instanceProductRepository.saveAndFlush(instanceProduct));
    }

    @Override
    public InstanceProductDto addToCart(InstanceProductDto instanceProductDto) {
        String[] values = instanceProductDto.getValues();
        InstanceProduct instanceProduct = instanceProductRepository.findById(instanceProductDto.getIdOfInstanceProduct()).get();
        Client client = clientRepository.findByEmail(instanceProductDto.getEmailOfClient());
        try {
            cartRepository.findById(client.getId()).get();
        } catch (NoSuchElementException e) {
            Cart cart = new Cart();
            cart.setId(client.getId());
            cartRepository.saveAndFlush(cart);
        }
        instanceProduct.setCart(cartRepository.findById(client.getId()).get());
        instanceProduct.setNumber(instanceProductDto.getNumber());

        List<ProductAttribute> productAttributeList = productAttributeRepository.findByCategory_Id(instanceProductDto.getIdOfCategory());
        int cycleStage = 0;
        for (ProductAttribute productAttribute : productAttributeList) {
            ProductAttributeValue pav = new ProductAttributeValue();
            pav.setValue(values[cycleStage]);
            pav.setProductAttribute(productAttribute);
            pav.setInstanceProduct(instanceProduct);
            productAttributeValueRepository.saveAndFlush(pav);
            cycleStage++;
        }
        return instanceProductConverter.toDto(instanceProductRepository.saveAndFlush(instanceProduct));
    }

    @Override
    public void deleteById(Long id) {
        instanceProductRepository.deleteById(id);
    }

    @Override
    public List<InstanceProductDto> findAll() {
        return instanceProductConverter.toListDto(instanceProductRepository.findAll());
    }

    @Override
    public Optional<InstanceProductDto> findById(Long id) {
        return instanceProductConverter.toOptionalDto(instanceProductRepository.findById(id));
    }
}
