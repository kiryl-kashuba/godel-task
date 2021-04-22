package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.InstanceProductService;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instance_products")
public class InstanceProductController {
    private final InstanceProductService instanceProductService;

    @Autowired
    public InstanceProductController(InstanceProductService instanceProductService) {
        this.instanceProductService = instanceProductService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    InstanceProduct create(@RequestBody InstanceProductDto instanceProductDto) {
        return instanceProductService.createInstanceProduct(instanceProductDto);
    }

    @PostMapping("/add_to_cart")
    @ResponseStatus(HttpStatus.CREATED)
    InstanceProduct addToCart(@RequestBody InstanceProductDto instanceProductDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        instanceProductDto.setEmailOfClient(authentication.getName());
        return instanceProductService.addToCart(instanceProductDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
        instanceProductService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<InstanceProduct> findAll() {
        return instanceProductService.findInstanceProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<InstanceProduct> findById(@PathVariable("id") Long id) {
        return instanceProductService.findById(id);
    }
}
