package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> createOrder(Order order, int idCart);

    List<Order> deleteOrder(int idOrder);

    List<Order> findOrders();
}
