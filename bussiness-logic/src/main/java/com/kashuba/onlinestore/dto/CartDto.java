package com.kashuba.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.InstanceProduct;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto extends BaseEntityDto {
    @JsonIgnore
    private List<InstanceProduct> instanceProductList;
    private Client client;


    public CartDto(Client client, List<InstanceProduct> instanceProductList) {
        this.client = client;
        this.instanceProductList = instanceProductList;
    }
}
