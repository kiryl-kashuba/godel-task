package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.OrderService;
import com.kashuba.onlinestore.service.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    Order create(@RequestBody OrderDto orderDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderDto.setEmailOfClient(authentication.getName());
        return orderService.createOrder(orderDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Order> findAll() {
        return orderService.findOrders();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Order> findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }
}
