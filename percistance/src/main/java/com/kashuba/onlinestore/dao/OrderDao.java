package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Order;

import java.util.List;

public interface OrderDao {

    List<Order> createOrder(Order order, int idCart);

    List<Order> deleteOrder(int idOrder);

    List<Order> findOrders();
}
