package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.OrderDto;
import com.kashuba.onlinestore.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Api(tags = "Controller of orders")
@Validated
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Create order")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto create(@RequestBody OrderDto orderDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderDto.setEmailOfClient(authentication.getName());
        log.info("Creating {} order", orderDto.getEmailOfClient());
        return orderService.create(orderDto);
    }

    @Operation(summary = "Delete order by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting order {}", id);
        orderService.deleteById(id);
    }

    @Operation(summary = "Find all orders")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAll() {
        log.info("Finding all orders");
        return orderService.findAll();
    }

    @Operation(summary = "Find order by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<OrderDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding order {}", id);
        return orderService.findById(id);
    }
}
