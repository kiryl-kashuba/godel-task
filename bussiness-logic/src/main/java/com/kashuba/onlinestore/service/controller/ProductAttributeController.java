package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.service.ProductAttributeService;
import com.kashuba.onlinestore.service.dto.ProductAttributeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    void delete(@PathVariable("id") ProductAttribute productAttribute) {
        productAttributeService.deleteProductAttribute(productAttribute);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductAttribute> findAllProductAttributes() {
        return productAttributeService.findProductAttributes();
    }
}
