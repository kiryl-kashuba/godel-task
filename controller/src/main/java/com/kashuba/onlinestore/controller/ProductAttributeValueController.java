package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.ProductAttributeValueDto;
import com.kashuba.onlinestore.service.ProductAttributeValueService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-attribute-values")
@Api(tags = "Controller of product attribute values")
@Validated
public class ProductAttributeValueController {
    private final ProductAttributeValueService productAttributeValueService;

    @Autowired
    public ProductAttributeValueController(ProductAttributeValueService productAttributeValueService) {
        this.productAttributeValueService = productAttributeValueService;
    }

    //@Operation(summary = "Create Find product attribute value")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductAttributeValueDto createProductAttributeValue(@RequestBody ProductAttributeValueDto productAttributeValueDto) {
        return productAttributeValueService.create(productAttributeValueDto);
    }

    //@Operation(summary = "Delete Find product attribute value by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        productAttributeValueService.deleteById(id);
    }

    //@Operation(summary = "Find all Find product attribute values")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAttributeValueDto> findAllProductAttributeValues() {
        return productAttributeValueService.findAll();
    }

    //@Operation(summary = "Find product attribute value by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductAttributeValueDto> findById(@PathVariable("id") Long id) {
        return productAttributeValueService.findById(id);
    }
}
