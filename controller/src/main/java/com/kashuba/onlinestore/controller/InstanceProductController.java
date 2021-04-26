package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.service.InstanceProductService;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
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
@RequestMapping("/instance_products")
@Api(tags = "Controller of instance products")
@Validated
public class InstanceProductController {
    private final InstanceProductService instanceProductService;

    @Autowired
    public InstanceProductController(InstanceProductService instanceProductService) {
        this.instanceProductService = instanceProductService;
    }

    @Operation(summary = "Create instance product")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstanceProductDto create(@Valid @RequestBody InstanceProductDto instanceProductDto) {
        return instanceProductService.create(instanceProductDto);
    }

    @Operation(summary = "Add instance product to cart")
    @PostMapping("/add_to_cart")
    @ResponseStatus(HttpStatus.CREATED)
    public InstanceProductDto addToCart(@Valid @RequestBody InstanceProductDto instanceProductDto) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        instanceProductDto.setEmailOfClient("qweqwe");
        return instanceProductService.addToCart(instanceProductDto);
    }

    @Operation(summary = "Delete instance product by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        instanceProductService.deleteById(id);
    }

    @Operation(summary = "Find all instance products")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InstanceProductDto> findAll() {
        return instanceProductService.findAll();
    }

    @Operation(summary = "Find instance product by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<InstanceProductDto> findById(@Valid @PathVariable("id") Long id) {
        return instanceProductService.findById(id);
    }
}
