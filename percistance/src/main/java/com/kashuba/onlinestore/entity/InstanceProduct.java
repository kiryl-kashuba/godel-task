package com.kashuba.onlinestore.entity;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class InstanceProduct extends BaseEntity {

    private String name;
    private String articulation;
    private int price;
    private Category category;
    private int number;
    private List<ProductAttributeValue> productAttributeValue;
    private Cart cart;


    public InstanceProduct(long id, String name, String articulation, int price, Category category, List<ProductAttributeValue> productAttributeValue) {
        super(id);
        this.name = name;
        this.articulation = articulation;
        this.price = price;
        this.category = category;
        this.productAttributeValue = productAttributeValue;
    }

    public InstanceProduct(String name, String articulation, int price) {
        this.name = name;
        this.articulation = articulation;
        this.price = price;
    }
}
