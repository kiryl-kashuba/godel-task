package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.ProductAttributeService;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product_attributes")
public class ProductAttributeController {
    private final ProductAttributeService productAttributeService;

    @Autowired
    public ProductAttributeController(ProductAttributeService productAttributeService) {
        this.productAttributeService = productAttributeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductAttribute createProductAttribute(@RequestBody ProductAttributeDto productAttributeDto) {
        return productAttributeService.createProductAttribute(productAttributeDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
        productAttributeService.deleteProductAttribute(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductAttribute> findAllProductAttributes() {
        return productAttributeService.findProductAttributes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<ProductAttribute> findById(@PathVariable("id") Long id) {
        return productAttributeService.findById(id);
    }
}
