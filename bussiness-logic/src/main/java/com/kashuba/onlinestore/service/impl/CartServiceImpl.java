package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.CartDaoImpl;
import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {

    private static CartServiceImpl instance;

    private CartServiceImpl() {
    }

    public static CartServiceImpl getInstance() {
        if (instance == null) {
            instance = new CartServiceImpl();
        }
        return instance;
    }

    CartDaoImpl cartDao = CartDaoImpl.getInstance();

    @Override
    public List<Cart> createCart(Cart cart) {
        return cartDao.createCart(cart);
    }

    @Override
    public List<Cart> deleteCart(int idCart) {
        return cartDao.deleteCart(idCart);
    }

    @Override
    public List<Cart> findCarts() {
        return cartDao.findCarts();
    }

    @Override
    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        return cartDao.addInstanceToCart(idCart, idInstance, amount);
    }


}
