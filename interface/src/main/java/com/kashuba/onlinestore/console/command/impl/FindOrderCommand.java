package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.impl.OrderServiceImpl;

import java.util.List;

public class FindOrderCommand {

    private static FindOrderCommand instance;
    private OrderServiceImpl orderService = OrderServiceImpl.getInstance();

    private FindOrderCommand() {
    }

    public static FindOrderCommand getInstance() {
        if (instance == null) {
            instance = new FindOrderCommand();
        }
        return instance;
    }


    public List<Order> findOrders() {
        return orderService.findOrders();
    }

}
