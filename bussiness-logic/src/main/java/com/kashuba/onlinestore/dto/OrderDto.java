package com.kashuba.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto extends BaseEntityDto {

    private String emailOfClient;
    private LocalDate dateOrder;
    private Long amount;

    public OrderDto(Long amount, LocalDate dateOrder) {
        this.dateOrder = dateOrder;
        this.amount = amount;
    }
}
