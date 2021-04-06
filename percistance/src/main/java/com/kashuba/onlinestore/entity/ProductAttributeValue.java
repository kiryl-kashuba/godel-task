package com.kashuba.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_attribute_values")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeValue extends BaseEntity {

    private String value;
    @ManyToOne(optional = false)
    @JoinColumn(name = "instanceProduct_id")
    private InstanceProduct instanceProduct;
    @ManyToOne(optional = false)
    @JoinColumn(name = "productAttribute_id")
    private ProductAttribute productAttribute;
}
