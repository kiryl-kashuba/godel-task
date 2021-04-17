package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.dto.CartDto;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Cart createCart(CartDto CartDto);

    void deleteCart(Long id);

    List<Cart> findCarts();

    Optional<Cart> findById(Long id);


//    Cart addInstanceToCart(int idCart, int idInstance, Integer amount);
//
//    Cart findCategoryById(int idCart);
}
