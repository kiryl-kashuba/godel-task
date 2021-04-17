package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.InstanceProductService;
import com.kashuba.onlinestore.service.dto.InstanceProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// TODO разделить слова
@RequestMapping("/instanceproducts")
public class InstanceProductController {
    private final InstanceProductService instanceProductService;

    @Autowired
    public InstanceProductController(InstanceProductService instanceProductService) {
        this.instanceProductService = instanceProductService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    InstanceProduct createInstanceProduct(@RequestBody InstanceProductDto instanceProductDto) {
        return instanceProductService.createInstanceProduct(instanceProductDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
        instanceProductService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<InstanceProduct> findAllInstanceProducts() {
        return instanceProductService.findInstanceProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
        // TODO перепроверить этот метод
    Optional<InstanceProduct> findById(@PathVariable("id") Long id) {
        return instanceProductService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    InstanceProduct addInstanceProductToCart(@RequestBody InstanceProductDto instanceProductDto) {
        return instanceProductService.createInstanceProduct(instanceProductDto);
    }
}
