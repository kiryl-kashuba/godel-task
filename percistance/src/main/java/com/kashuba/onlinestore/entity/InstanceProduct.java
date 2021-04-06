package com.kashuba.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instance_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstanceProduct extends BaseEntity {

    private String name;
    private String articulation;
    private int price;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;
    private int number;
    @OneToMany(mappedBy = "instanceProduct")
    private List<ProductAttributeValue> productAttributeValue;
    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
