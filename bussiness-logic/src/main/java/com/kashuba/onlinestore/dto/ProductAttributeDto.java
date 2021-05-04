package com.kashuba.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAttributeDto extends BaseEntityDto {
    @Size(min = 1, max = 60, message = "name must be between 1 and 60 characters long")
    private String name;
    private boolean mandatory;
    @Size(min = 3, max = 10, message = "type must be between 3 and 10 characters long")
    private String type;
    @PositiveOrZero
    private Long idOfCategory;

    public ProductAttributeDto(String name, String type, boolean mandatory) {
        this.name = name;
        this.mandatory = mandatory;
        this.type = type;
    }
}
