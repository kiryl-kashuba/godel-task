package com.kashuba.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.entity.ProductAttribute;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAttributeValueDto extends BaseEntityDto {

    private String value;
    @JsonIgnore
    private InstanceProduct instanceProduct;
    private ProductAttribute productAttribute;
}
