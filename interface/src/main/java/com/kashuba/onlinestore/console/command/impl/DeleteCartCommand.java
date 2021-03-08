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

    public List<Cart> deleteCart(int idCart) {
        return CartServiceImpl.getInstance().deleteCart(idCart);
    }
}
