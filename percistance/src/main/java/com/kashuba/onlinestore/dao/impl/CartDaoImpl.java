package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.CartDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

public class CartDaoImpl implements CartDao {

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
    public List<Cart> createCart(Cart cart) {
        cart.setId(IdGenerator.createID());
        FileInitialization.getInstance().getReadedCart().add(cart);
        return FileInitialization.getInstance().getReadedCart();
    }

    @Override
    public List<Cart> deleteCart(int idCart) {
        FileInitialization.getInstance().getReadedCart().removeIf(x -> x.getId() == idCart);
        return FileInitialization.getInstance().getReadedCart();
    }

    @Override
    public List<Cart> findCarts() {
        return FileInitialization.getInstance().getReadedCart();
    }

    @Override
    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        Cart returnCart = null;
        for (Cart cart : FileInitialization.getInstance().getReadedCart()) {
            if (idCart == cart.getId()) {
                returnCart = cart;
                for (InstanceProduct instanceProduct : FileInitialization.getInstance().getReadedProduct()) {
                    if (idInstance == instanceProduct.getId()) {
                        cart.getNumber().put(instanceProduct, amount);
                        cart.addInstanceProduct(instanceProduct);
                    }
                }
            }
        }
        return returnCart;
    }

}