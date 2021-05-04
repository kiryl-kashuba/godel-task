package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.ProductAttributeDto;
import com.kashuba.onlinestore.service.ProductAttributeService;
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
@RequestMapping("/product-attributes")
@Validated
@Slf4j
@Api(tags = "Controller of product attributes", description = "Operations with product attributes")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 409, message = "The request could not be completed due to a conflict with the current state of the target resource."),
        @ApiResponse(code = 500, message = "Server ERROR. Something go wrong")
})
public class ProductAttributeController {
    @Autowired
    private ProductAttributeService productAttributeService;

    @ApiOperation(value = "Create product attribute")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductAttributeDto createProductAttribute(@Valid @RequestBody ProductAttributeDto productAttributeDto) {
        log.info("Creating product attribute {}", productAttributeDto.getName());
        return productAttributeService.create(productAttributeDto);
    }

    @ApiOperation(value = "Delete product attribute")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting product attribute {}", id);
        productAttributeService.deleteById(id);
    }

    @ApiOperation(value = "Find all product attributes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAttributeDto> findAllProductAttributes() {
        log.info("Finding all product attributes");
        return productAttributeService.findAll();
    }

    @ApiOperation(value = "Find product attribute by ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductAttributeDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding product attribute {}", id);
        return productAttributeService.findById(id);
    }
}
