package com.kashuba.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstanceProductDto extends BaseEntityDto {

    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "articulation is mandatory")
    private String articulation;
    private Integer price;
    private Long idOfCategory;
    private Long idOfInstanceProduct;
    private int number;
    private String emailOfClient;
    private String[] values;

    public InstanceProductDto(String articulation, int price, String name) {
        this.name = name;
        this.articulation = articulation;
        this.price = price;
    }
}
