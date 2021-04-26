package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.service.OrderService;
import com.kashuba.onlinestore.service.dto.OrderDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Api(tags = "Controller of orders")
@Validated
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
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderDto.setEmailOfClient("qweqwe");
        return orderService.create(orderDto);
    }

    @Operation(summary = "Delete order by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        orderService.deleteById(id);
    }

    @Operation(summary = "Find all orders")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @Operation(summary = "Find order by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<OrderDto> findById(@Valid @PathVariable("id") Long id) {
        return orderService.findById(id);
    }
}
