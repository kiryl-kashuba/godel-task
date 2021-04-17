package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.OrderService;
import com.kashuba.onlinestore.service.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    void delete(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Order> findAllClients() {
        return orderService.findOrders();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Order> findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }
}
