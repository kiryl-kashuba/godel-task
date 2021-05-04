package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.CartDto;
import com.kashuba.onlinestore.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Validated
@Slf4j
@Api(tags = "Controller of carts", description = "Operations with carts")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 409, message = "The request could not be completed due to a conflict with the current state of the target resource."),
        @ApiResponse(code = 500, message = "Server ERROR. Something go wrong")
})
public class CartController {
    @Autowired
    private CartService cartService;

    @ApiOperation(value = "Create cart")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto create(@Valid @RequestBody CartDto cartDto) {
        log.info("Creating cart");
        return cartService.create(cartDto);
    }

    @ApiOperation(value = "Delete cart")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> findAll() {
        log.info("Finding all carts ");
        return cartService.findAll();
    }

    @ApiOperation(value = "Find cart by ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CartDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding cart {}", id);
        return cartService.findById(id);
    }
}
