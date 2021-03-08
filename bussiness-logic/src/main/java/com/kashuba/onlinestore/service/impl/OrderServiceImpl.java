package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.OrderDaoImpl;
import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl instance;

    private OrderServiceImpl() {
    }

    public static OrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Order> createOrder(Order order) {
        return OrderDaoImpl.getInstance().createOrder(order);
    }

    @Override
    public List<Order> deleteOrder(int idOrder) {
        return OrderDaoImpl.getInstance().deleteOrder(idOrder);
    }

    @Override
    public List<Order> findOrders() {
        return OrderDaoImpl.getInstance().findOrders();
    }
}
