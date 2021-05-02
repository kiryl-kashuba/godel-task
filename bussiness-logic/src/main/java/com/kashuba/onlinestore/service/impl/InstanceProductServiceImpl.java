package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.converter.InstanceProductConverter;
import com.kashuba.onlinestore.dao.*;
import com.kashuba.onlinestore.dto.InstanceProductDto;
import com.kashuba.onlinestore.entity.*;
import com.kashuba.onlinestore.service.InstanceProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public InstanceProductDto addToCart(InstanceProductDto instanceProductDto) {
        String[] values = instanceProductDto.getValues();
        InstanceProduct instanceProduct = instanceProductRepository.findById(instanceProductDto.getIdOfInstanceProduct()).get();
        Client client = clientRepository.findByEmail(instanceProductDto.getEmailOfClient());
        Optional<Cart> existingCart = cartRepository.findById(client.getId());
        instanceProduct.setCart(existingCart.get());
        instanceProduct.setNumber(instanceProductDto.getNumber());

        List<ProductAttribute> productAttributeList = productAttributeRepository.findByCategory_Id(instanceProductDto.getIdOfCategory());
        for (ProductAttribute productAttribute : productAttributeList) {
            ProductAttributeValue pav = new ProductAttributeValue();
            pav.setValue(values[productAttributeList.size()]);
            pav.setProductAttribute(productAttribute);
            pav.setInstanceProduct(instanceProduct);
            productAttributeValueRepository.saveAndFlush(pav);
        }
        return instanceProductConverter.toDto(instanceProductRepository.saveAndFlush(instanceProduct)); // TODO что произойдет, если у меня на return'е упадет приложение?
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
