package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_attribute_values")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeValue extends BaseEntity {

    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "instance_product_id", nullable = true, insertable = false, updatable = false)
    //productAttribute_id
    private InstanceProduct instanceProduct;

    private String value;
    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "product_attribute_id", nullable = true, insertable = false, updatable = false)
    //productAttribute_id
    private ProductAttribute productAttribute;

    public ProductAttributeValue(String value) {
        this.value = value;
    }
}
