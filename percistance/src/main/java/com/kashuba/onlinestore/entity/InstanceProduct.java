package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instance_products")
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class InstanceProduct extends BaseEntity {

    private String name;
    private String articulation;
    private int price;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    private int number;
    @OneToMany(mappedBy = "instanceProduct")
    private List<ProductAttributeValue> productAttributeValue;
    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

}
