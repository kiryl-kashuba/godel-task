package com.kashuba.onlinestore.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductAttribute extends BaseEntity {

    private String name;
    private boolean mandatory;
    private String type;
    private Category category;
    private int number;

    public ProductAttribute(String name, boolean mandatory, String type, Category category) {
        this.name = name;
        this.mandatory = mandatory;
        this.type = type;
        this.category = category;
    }
}
