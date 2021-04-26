package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.service.CartService;
import com.kashuba.onlinestore.service.dto.CartDto;
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
@RequestMapping("/carts")
@Api(tags = "Controller of carts")
@Validated
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Operation(summary = "Create cart")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto create(@Valid @RequestBody CartDto cartDto) {
        return cartService.create(cartDto);
    }

    @Operation(summary = "Find all carts")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> findAll() {
        return cartService.findAll();
    }

    @Operation(summary = "Find cart by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CartDto> findById(@Valid @PathVariable("id") Long id) {
        return cartService.findById(id);
    }
}
