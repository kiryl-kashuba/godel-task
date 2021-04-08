package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.dto.OrderDto;

import java.util.List;

public interface OrderService {

    Order createOrder(OrderDto orderDto, int idCart);

    void deleteOrder(int idOrder);

    List<Order> findOrders();
}
