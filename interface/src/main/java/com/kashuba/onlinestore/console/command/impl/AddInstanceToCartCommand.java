package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.impl.CartServiceImpl;

public class AddInstanceToCartCommand {

    private static AddInstanceToCartCommand instance;

    private AddInstanceToCartCommand() {
    }

    public static AddInstanceToCartCommand getInstance() {
        if (instance == null) {
            instance = new AddInstanceToCartCommand();
        }
        return instance;
    }

    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        return CartServiceImpl.getInstance().addInstanceToCart(idCart, idInstance, amount);
    }

}
