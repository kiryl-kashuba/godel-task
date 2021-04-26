package com.kashuba.onlinestore.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kashuba.onlinestore.entity.ProductAttribute;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto extends BaseEntityDto {
    @NotBlank(message = "name is mandatory")
    private String name;
    @JsonIgnore
    private List<ProductAttribute> productAttribute;

    public CategoryDto(String name, List<ProductAttribute> productAttribute) {
        this.name = name;
        this.productAttribute = productAttribute;
    }
}
