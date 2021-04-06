package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_attributes")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class ProductAttribute extends BaseEntity {

    private String name;
    private boolean mandatory;
    private String type;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;
    private int number;

    public ProductAttribute(String name, boolean mandatory, String type, Category category) {
        this.name = name;
        this.mandatory = mandatory;
        this.type = type;
        this.category = category;
    }
}
