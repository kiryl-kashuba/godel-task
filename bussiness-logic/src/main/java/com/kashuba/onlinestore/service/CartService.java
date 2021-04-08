package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findCarts();

    Cart addInstanceToCart(int idCart, int idInstance, Integer amount);

    Cart findCategoryById(int idCart);
}
