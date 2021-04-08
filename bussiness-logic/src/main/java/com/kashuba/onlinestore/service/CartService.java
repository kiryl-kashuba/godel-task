package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.dto.CartDto;

import java.util.List;

public interface CartService {

    Cart createCart(CartDto CartDto);

    void deleteCart(Cart Cart);

    List<Cart> findCarts();

//    Cart addInstanceToCart(int idCart, int idInstance, Integer amount);
//
//    Cart findCategoryById(int idCart);
}
