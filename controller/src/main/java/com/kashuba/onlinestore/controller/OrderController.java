package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.OrderDto;
import com.kashuba.onlinestore.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Validated
@Slf4j
@Api(tags = "Controller of orders", description = "Operations with orders")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 409, message = "The request could not be completed due to a conflict with the current state of the target resource."),
        @ApiResponse(code = 500, message = "Server ERROR. Something go wrong")
})
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "Create order")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto create(@RequestBody OrderDto orderDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderDto.setEmailOfClient(authentication.getName());
        log.info("Creating {} order", orderDto.getEmailOfClient());
        return orderService.create(orderDto);
    }

    @ApiOperation(value = "Delete order")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting order {}", id);
        orderService.deleteById(id);
    }

    @ApiOperation(value = "Find all orders")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAll() {
        log.info("Finding all orders");
        return orderService.findAll();
    }

    @ApiOperation(value = "Find order by ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<OrderDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding order {}", id);
        return orderService.findById(id);
    }
}
