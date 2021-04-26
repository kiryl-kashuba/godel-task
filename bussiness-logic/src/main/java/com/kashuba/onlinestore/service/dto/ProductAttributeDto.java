package com.kashuba.onlinestore.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAttributeDto extends BaseEntityDto {
    @NotBlank(message = "name is mandatory")
    private String name;
    private boolean mandatory;
    @NotBlank(message = "type is mandatory")
    private String type;
    //    private Category category;
    private Long idOfCategory;

    public ProductAttributeDto(String name, String type, boolean mandatory) {
        this.name = name;
        this.mandatory = mandatory;
        this.type = type;
    }
}
