package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.OrderRepository;
import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.OrderService;
import com.kashuba.onlinestore.service.converter.OrderConverter;
import com.kashuba.onlinestore.service.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    OrderConverter orderConverter = new OrderConverter();
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderDto orderDto) {
        Order order = orderConverter.toModel(orderDto);
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

}
