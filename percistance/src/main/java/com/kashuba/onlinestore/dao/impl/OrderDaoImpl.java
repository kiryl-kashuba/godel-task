package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.OrderDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private static OrderDaoImpl instance;

    private OrderDaoImpl() {
    }

    public static OrderDaoImpl getInstance() {
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Order> createOrder(Order order) {
        order.setId(IdGenerator.createID());
        FileInitialization.getInstance().getReadedOrder().add(order);
        return FileInitialization.getInstance().getReadedOrder();
    }

    @Override
    public List<Order> deleteOrder(int idOrder) {
        FileInitialization.getInstance().getReadedOrder().removeIf(x -> x.getId() == idOrder);
        return FileInitialization.getInstance().getReadedOrder();
    }

    @Override
    public List<Order> findOrders() {
        return FileInitialization.getInstance().getReadedOrder();
    }
}
