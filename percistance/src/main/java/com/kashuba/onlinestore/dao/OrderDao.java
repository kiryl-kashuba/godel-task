package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Order;

import java.util.List;

public interface OrderDao {

    List<Order> create(Order order, int idCart);

    List<Order> delete(int id);

    List<Order> find();
}
