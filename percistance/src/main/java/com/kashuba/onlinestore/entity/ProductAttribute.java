package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_attributes")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ProductAttribute extends BaseEntity {

    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    private String name;
    private boolean mandatory;
    private String type;

    public ProductAttribute(String name, boolean mandatory, String type) {
        this.name = name;
        this.mandatory = mandatory;
        this.type = type;
    }
}
