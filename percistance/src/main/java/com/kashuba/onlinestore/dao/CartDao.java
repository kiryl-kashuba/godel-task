package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Cart;

public interface CartDao {

    Cart addInstanceToCart(int idOfCart, int idInstance, Integer amount);
}
