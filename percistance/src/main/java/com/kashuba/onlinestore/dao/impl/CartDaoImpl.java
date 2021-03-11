package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.entity.BaseEntity;
import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.entity.InstanceProduct;

import java.util.List;

public class CartDaoImpl extends CRUDDao {

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
    public List<Cart> create(BaseEntity object) {
        object.setId(IdGenerator.createID());
        fileInitialization.getReadedCart().add((Cart) object);
        return fileInitialization.getReadedCart();
    }

    @Override
    public List<Cart> delete(int id) {
        fileInitialization.getReadedCart().removeIf(x -> x.getId() == id);
        return fileInitialization.getReadedCart();
    }

    @Override
    public List<Cart> find() {
        return fileInitialization.getReadedCart();
    }


    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        Cart returnCart = null;
        for (Cart cart : fileInitialization.getReadedCart()) {
            if (idCart == cart.getId()) {
                returnCart = cart;
                for (InstanceProduct instanceProduct : fileInitialization.getReadedProduct()) {
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