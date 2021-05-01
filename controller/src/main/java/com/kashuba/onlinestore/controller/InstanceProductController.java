package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.InstanceProductDto;
import com.kashuba.onlinestore.service.InstanceProductService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/instance-products")
@Api(tags = "Controller of instance products")
@Validated
@Slf4j
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
        log.info("Creating instance product {} {}", instanceProductDto.getName(), instanceProductDto.getArticulation());
        return instanceProductService.create(instanceProductDto);
    }

    @Operation(summary = "Add instance product to cart")
    @PostMapping("/to-cart")
    @ResponseStatus(HttpStatus.CREATED)
    public InstanceProductDto addToCart(@Valid @RequestBody InstanceProductDto instanceProductDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        instanceProductDto.setEmailOfClient(authentication.getName());
        log.info("Adding instance product {} {} to {} cart", instanceProductDto.getName(),
                instanceProductDto.getArticulation(), instanceProductDto.getEmailOfClient());
        return instanceProductService.addToCart(instanceProductDto);
    }

    @Operation(summary = "Delete instance product by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting instance product {}", id);
        instanceProductService.deleteById(id);
    }

    @Operation(summary = "Find all instance products")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InstanceProductDto> findAll() {
        log.info("Finding all instance products");
        return instanceProductService.findAll();
    }

    @Operation(summary = "Find instance product by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<InstanceProductDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding instance product {}", id);
        return instanceProductService.findById(id);
    }
}
