package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Cart;

import java.util.List;

public interface CartDao {

    List<Cart> create(Cart cart);

    List<Cart> delete(int id);

    List<Cart> find();

    Cart addInstanceToCart(int idOfCart, int idInstance, Integer amount);
}
