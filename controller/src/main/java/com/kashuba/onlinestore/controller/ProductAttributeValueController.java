package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.ProductAttributeValueDto;
import com.kashuba.onlinestore.service.ProductAttributeValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-attribute-values")
@Validated
@Slf4j
@Api(tags = "Controller of product attribute values", description = "Operations with product attribute values")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 409, message = "The request could not be completed due to a conflict with the current state of the target resource."),
        @ApiResponse(code = 500, message = "Server ERROR. Something go wrong")
})
public class ProductAttributeValueController {
    @Autowired
    private ProductAttributeValueService productAttributeValueService;

    @ApiOperation(value = "Create product attribute value")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductAttributeValueDto createProductAttributeValue(@RequestBody ProductAttributeValueDto productAttributeValueDto) {
        log.info("Creating product attribute value {}", productAttributeValueDto.getValue());
        return productAttributeValueService.create(productAttributeValueDto);
    }

    @ApiOperation(value = "Delete product attribute value")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("Deleting product attribute value {}", id);
        productAttributeValueService.deleteById(id);
    }

    @ApiOperation(value = "Find all product attribute values")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAttributeValueDto> findAllProductAttributeValues() {
        log.info("Finding all product attribute values");
        return productAttributeValueService.findAll();
    }

    @ApiOperation(value = "Find product attribute value by ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductAttributeValueDto> findById(@PathVariable("id") Long id) {
        log.info("Finding product attribute value {}", id);
        return productAttributeValueService.findById(id);
    }
}
