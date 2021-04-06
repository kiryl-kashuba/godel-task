package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instance_products")
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
