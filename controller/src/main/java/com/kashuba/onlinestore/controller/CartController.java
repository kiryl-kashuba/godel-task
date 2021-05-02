package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.CartDto;
import com.kashuba.onlinestore.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //This comment at the bottom is still useful to me, sorry.

//    //@Operation(summary = "Create cart")
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public CartDto create(@Valid @RequestBody CartDto cartDto) {
//        log.info("Creating cart");
//        return cartService.create(cartDto);
//    }

    //    //@Operation(summary = "Find all carts")
    @ApiOperation(value = "Delete user")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> findAll() {
        log.info("Finding all carts ");
        return cartService.findAll();
    }

    //    //@Operation(summary = "Find cart by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CartDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding cart {}", id);
        return cartService.findById(id);
    }
}
