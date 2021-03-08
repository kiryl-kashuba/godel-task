package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.impl.OrderServiceImpl;

import java.util.List;

public class DeleteOrderCommand {

    private static DeleteOrderCommand instance;

    private DeleteOrderCommand() {
    }

    public static DeleteOrderCommand getInstance() {
        if (instance == null) {
            instance = new DeleteOrderCommand();
        }
        return instance;
    }

    public List<Order> deleteCLient(int idOrder) {
        return OrderServiceImpl.getInstance().deleteOrder(idOrder);
    }
}
