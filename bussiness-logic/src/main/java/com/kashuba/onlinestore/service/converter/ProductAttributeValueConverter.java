package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.ProductAttributeValue;
import com.kashuba.onlinestore.service.dto.ProductAttributeValueDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductAttributeValueConverter {

    public ProductAttributeValue toModel(ProductAttributeValueDto productAttributeValueDto) {
        return new ProductAttributeValue(productAttributeValueDto.getValue());
    }

    public ProductAttributeValueDto toDto(ProductAttributeValue productAttributeValue) {
        return new ProductAttributeValueDto(productAttributeValue.getValue(),
                productAttributeValue.getInstanceProduct(), productAttributeValue.getProductAttribute());
    }

    public Optional<ProductAttributeValueDto> toOptionalDto(Optional<ProductAttributeValue> productAttributeValue) {
        ProductAttributeValueDto productAttributeValueDto = new ProductAttributeValueDto(
                productAttributeValue.get().getValue(), productAttributeValue.get().getInstanceProduct(),
                productAttributeValue.get().getProductAttribute());
        return Optional.of(productAttributeValueDto);
    }

    public List<ProductAttributeValueDto> toListDto(List<ProductAttributeValue> productAttributeValueList) {
        List<ProductAttributeValueDto> productAttributeValueDtos = new ArrayList<>();
        for (ProductAttributeValue productAttributeValue : productAttributeValueList) {
            productAttributeValueDtos.add(new ProductAttributeValueDto(productAttributeValue.getValue(),
                    productAttributeValue.getInstanceProduct(), productAttributeValue.getProductAttribute()));
        }
        return productAttributeValueDtos;
    }
}
