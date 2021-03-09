package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.impl.CartServiceImpl;

import java.util.List;

public class FindCartCommand {

    private static FindCartCommand instance;

    private FindCartCommand() {
    }

    public static FindCartCommand getInstance() {
        if (instance == null) {
            instance = new FindCartCommand();
        }
        return instance;
    }

    CartServiceImpl cartService = CartServiceImpl.getInstance();

    public List<Cart> findCarts() {
        return cartService.findCarts();
    }

}
