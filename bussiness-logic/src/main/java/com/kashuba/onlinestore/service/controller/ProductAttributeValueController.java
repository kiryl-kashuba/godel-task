package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.ProductAttributeValueService;
import com.kashuba.onlinestore.service.dto.ProductAttributeValueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product_attribute_values")
public class ProductAttributeValueController {
    private final ProductAttributeValueService productAttributeValueService;

    @Autowired
    public ProductAttributeValueController(ProductAttributeValueService productAttributeValueService) {
        this.productAttributeValueService = productAttributeValueService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductAttributeValue createProductAttributeValue(@RequestBody ProductAttributeValueDto productAttributeValueDto) {
        return productAttributeValueService.createProductAttributeValue(productAttributeValueDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
        productAttributeValueService.deleteProductAttributeValue(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductAttributeValue> findAllProductAttributeValues() {
        return productAttributeValueService.findProductAttributeValues();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<ProductAttributeValue> findById(@PathVariable("id") Long id) {
        return productAttributeValueService.findById(id);
    }
}
