package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.CartService;
import com.kashuba.onlinestore.service.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Cart createClient(@RequestBody CartDto cartDto) {
        return cartService.createCart(cartDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") String cartId) {
        Cart cart = new Cart();
        cart.setId(Long.parseLong(cartId));
        cartService.deleteCart(cart);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Cart> findAllClients() {
        return cartService.findCarts();
    }
}
