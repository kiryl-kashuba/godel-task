package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.impl.CartServiceImpl;

public class CreateCartCommand {

    private CartServiceImpl cartService = CartServiceImpl.getInstance();
    private static CreateCartCommand instance;

    private CreateCartCommand() {
    }

    public static CreateCartCommand getInstance() {
        if (instance == null) {
            instance = new CreateCartCommand();
        }
        return instance;
    }

    public Cart createInstance(Cart cart) {
        return cartService.createCart(cart);
    }
}
