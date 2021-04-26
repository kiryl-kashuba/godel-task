package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.service.ProductAttributeService;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
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
@RequestMapping("/product_attributes")
@Api(tags = "Controller of product attributes")
@Validated
public class ProductAttributeController {
    private final ProductAttributeService productAttributeService;

    @Autowired
    public ProductAttributeController(ProductAttributeService productAttributeService) {
        this.productAttributeService = productAttributeService;
    }

    @Operation(summary = "Create product attribute")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductAttributeDto createProductAttribute(@Valid @RequestBody ProductAttributeDto productAttributeDto) {
        return productAttributeService.create(productAttributeDto);
    }

    @Operation(summary = "Delete product attribute by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        productAttributeService.deleteById(id);
    }

    @Operation(summary = "Find all product attributes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAttributeDto> findAllProductAttributes() {
        return productAttributeService.findAll();
    }

    @Operation(summary = "Find product attribute by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductAttributeDto> findById(@Valid @PathVariable("id") Long id) {
        return productAttributeService.findById(id);
    }
}
