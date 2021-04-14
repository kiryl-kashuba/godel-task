package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.CartRepository;
import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.CartService;
import com.kashuba.onlinestore.service.converter.CartConverter;
import com.kashuba.onlinestore.service.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    CartConverter cartConverter = new CartConverter();

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart createCart(CartDto categoryDto) {
        Cart cart = cartConverter.toModel(categoryDto);
        return cartRepository.saveAndFlush(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);  //cartRepository.deleteById(client.getId());
    }

    @Override
    public List<Cart> findCarts() {
        return cartRepository.findAll();
    }
}
