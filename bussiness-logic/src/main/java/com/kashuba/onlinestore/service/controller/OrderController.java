package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.OrderService;
import com.kashuba.onlinestore.service.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Order createClient(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Order order) {
        orderService.deleteOrder(order);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Order> findAllClients() {
        return orderService.findOrders();
    }
}
