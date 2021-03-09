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

    OrderDaoImpl orderDao = OrderDaoImpl.getInstance();

    @Override
    public List<Order> createOrder(Order order, int idCart) {
        return orderDao.createOrder(order, idCart);
    }

    @Override
    public List<Order> deleteOrder(int idOrder) {
        return orderDao.deleteOrder(idOrder);
    }

    @Override
    public List<Order> findOrders() {
        return orderDao.findOrders();
    }
}
