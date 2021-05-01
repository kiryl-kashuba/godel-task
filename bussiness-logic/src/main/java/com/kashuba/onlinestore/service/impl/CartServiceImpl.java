package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.converter.CartConverter;
import com.kashuba.onlinestore.dao.CartRepository;
import com.kashuba.onlinestore.dto.CartDto;
import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    CartConverter cartConverter = new CartConverter();

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartDto create(CartDto categoryDto) {
        Cart cart = cartConverter.toModel();
        return cartConverter.toDto(cartRepository.saveAndFlush(cart));
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);  //cartRepository.deleteById(client.getId());
    }

    @Override
    public List<CartDto> findAll() {
        return cartConverter.toListDto(cartRepository.findAll());
    }

    public Optional<CartDto> findById(Long id) {
        return cartConverter.toOptionalDto(cartRepository.findById(id));
    }

}
