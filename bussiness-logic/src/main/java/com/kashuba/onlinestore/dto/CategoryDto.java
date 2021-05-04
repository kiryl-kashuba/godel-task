package com.kashuba.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kashuba.onlinestore.entity.ProductAttribute;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto extends BaseEntityDto {
    @NotNull(message = "Name must not be null")
    @Size(max = 40, message = "Name must not be longer than 40 characters")
    private String name;
    @JsonIgnore
    private List<ProductAttribute> productAttribute;

    public CategoryDto(String name, List<ProductAttribute> productAttribute) {
        this.name = name;
        this.productAttribute = productAttribute;
    }
}
