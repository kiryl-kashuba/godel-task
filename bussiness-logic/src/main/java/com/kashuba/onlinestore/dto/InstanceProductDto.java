package com.kashuba.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstanceProductDto extends BaseEntityDto {

    @NotNull(message = "SecondName must not be null")
    @Size(max = 40, message = "Name must not be longer than 15 characters")
    private String name;
    @Size(min = 11, max = 11, message = "Name must not be longer than 15 characters")
    private String articulation;
    @PositiveOrZero
    private Long price;
    @PositiveOrZero
    private Long idOfCategory;
    @PositiveOrZero
    private Long idOfInstanceProduct;
    @PositiveOrZero
    private Long number;
    private String emailOfClient;
    private String[] values;

    public InstanceProductDto(String articulation, Long price, String name) {
        this.name = name;
        this.articulation = articulation;
        this.price = price;
    }
}
