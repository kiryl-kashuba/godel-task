package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.impl.OrderServiceImpl;

import java.util.List;

public class CreateOrderCommand {

    private static CreateOrderCommand instance;

    private CreateOrderCommand() {
    }

    public static CreateOrderCommand getInstance() {
        if (instance == null) {
            instance = new CreateOrderCommand();
        }
        return instance;
    }

    public List<Order> createOrder(Order order, int idCart) {
        return OrderServiceImpl.getInstance().createOrder(order, idCart);
    }

}
