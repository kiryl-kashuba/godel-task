package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.CartDao;
import com.kashuba.onlinestore.entity.Cart;

import java.util.List;

public class CartDaoImpl extends AbstractCRUDDao<Cart> implements CartDao {

    private static CartDaoImpl instance;

    private CartDaoImpl() {
    }

    public static CartDaoImpl getInstance() {
        if (instance == null) {
            instance = new CartDaoImpl();
        }
        return instance;
    }


    @Override
    public Cart create(Cart cart) {
        cart.setId(IdGenerator.createID());
        return cart;
    }

    @Override
    public List<Cart> delete(int id) {
        return null;
    }

    @Override
    public List<Cart> find() {
        return null;
    }


    @Override
    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        Cart returnCart = null;

        return returnCart;
    }

}