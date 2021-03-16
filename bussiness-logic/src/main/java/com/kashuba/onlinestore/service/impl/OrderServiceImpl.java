package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.CartDaoImpl;
import com.kashuba.onlinestore.dao.impl.OrderDaoImpl;
import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.entity.InstanceProductContainer;
import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDaoImpl orderDao = OrderDaoImpl.getInstance();
    private CartDaoImpl cartDao = CartDaoImpl.getInstance();


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
    public Order createOrder(Order order, int idCart) {

        for (Cart cart : cartDao.find()) {
            if (idCart == cart.getId()) {
                order.setCart(cart);
            }
        }

        int amount = 0;

        for (Cart cart : cartDao.find()) {
            if (idCart == cart.getId()) {
                order.setCart(cart);
                for (InstanceProductContainer numberContainer : cart.getNumber()) {
                    amount += numberContainer.getInstanceProduct().getPrice() * numberContainer.getNumber();
                }
            }
        }
        order.setAmount(amount);

        return orderDao.create(order);
    }

    @Override
    public List<Order> deleteOrder(int id) {
        return orderDao.delete(id);
    }

    @Override
    public List<Order> findOrders() {
        return orderDao.find();
    }
}
