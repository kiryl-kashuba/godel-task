package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(OrderDto orderDto);

    void deleteOrder(Long id);

    List<Order> findOrders();

    Optional<Order> findById(Long id);
}
