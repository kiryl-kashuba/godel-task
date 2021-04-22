package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.CartService;
import com.kashuba.onlinestore.service.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
// TODO модификаторы доступа
// Не понял где я могу изменить\добавить модификаторы доступа
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Cart create(@RequestBody CartDto cartDto) {
        return cartService.createCart(cartDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Cart> findAll() {
        return cartService.findCarts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Cart> findById(@PathVariable("id") Long id) {
        return cartService.findById(id);
    }
}
