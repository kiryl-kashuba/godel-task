package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.impl.CartServiceImpl;

import java.util.List;

public class CreateCartCommand {

    private static CreateCartCommand instance;

    private CreateCartCommand() {
    }

    public static CreateCartCommand getInstance() {
        if (instance == null) {
            instance = new CreateCartCommand();
        }
        return instance;
    }

    public List<Cart> createInstance(Cart cart) {
        return CartServiceImpl.getInstance().createCart(cart);
    }
}
