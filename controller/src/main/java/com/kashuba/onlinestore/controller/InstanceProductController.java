package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.InstanceProductDto;
import com.kashuba.onlinestore.service.InstanceProductService;
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
@RequestMapping("/instance-products")
@Validated
@Slf4j
@Api(tags = "Controller of instance products", description = "Operations with specific product instances")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 409, message = "The request could not be completed due to a conflict with the current state of the target resource."),
        @ApiResponse(code = 500, message = "Server ERROR. Something go wrong")
})
public class InstanceProductController {
    @Autowired
    private InstanceProductService instanceProductService;

    @ApiOperation(value = "Create instance product")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstanceProductDto create(@Valid @RequestBody InstanceProductDto instanceProductDto) {
        log.info("Creating instance product {} {}", instanceProductDto.getName(), instanceProductDto.getArticulation());
        return instanceProductService.create(instanceProductDto);
    }

    @ApiOperation(value = "Add instance product to cart")
    @PostMapping("/to-cart")
    @ResponseStatus(HttpStatus.CREATED)
    public InstanceProductDto addToCart(@Valid @RequestBody InstanceProductDto instanceProductDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        instanceProductDto.setEmailOfClient(authentication.getName());
        log.info("Adding instance product {} {} to {} cart", instanceProductDto.getName(),
                instanceProductDto.getArticulation(), instanceProductDto.getEmailOfClient());
        return instanceProductService.addToCart(instanceProductDto);
    }

    @ApiOperation(value = "Delete instance product")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting instance product {}", id);
        instanceProductService.deleteById(id);
    }

    @ApiOperation(value = "Find all instance products")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InstanceProductDto> findAll() {
        log.info("Finding all instance products");
        return instanceProductService.findAll();
    }

    @ApiOperation(value = "Find instance product by ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<InstanceProductDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding instance product {}", id);
        return instanceProductService.findById(id);
    }
}
