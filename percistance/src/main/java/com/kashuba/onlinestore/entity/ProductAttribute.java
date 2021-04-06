package com.kashuba.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_attributes")
@Data
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
}
