package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Cart;

import java.util.List;

public interface CartDao {

    List<Cart> createCart(Cart cart);

    List<Cart> deleteCart(int idCart);

    List<Cart> findCarts();

    Cart addInstanceToCart(int idCart, int idInstance, Integer amount);
}
