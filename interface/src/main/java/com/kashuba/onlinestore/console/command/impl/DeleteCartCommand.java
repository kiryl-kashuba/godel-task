package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.impl.CartServiceImpl;

import java.util.List;

public class DeleteCartCommand {

    private static DeleteCartCommand instance;

    private DeleteCartCommand() {
    }

    public static DeleteCartCommand getInstance() {
        if (instance == null) {
            instance = new DeleteCartCommand();
        }
        return instance;
    }

    CartServiceImpl cartService = CartServiceImpl.getInstance();

    public List<Cart> deleteCart(int idCart) {
        return cartService.deleteCart(idCart);
    }
}
