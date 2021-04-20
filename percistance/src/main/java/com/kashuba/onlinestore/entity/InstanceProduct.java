package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "id", nullable = true, insertable = false, updatable = false)
    private Category category;

    private String name;
    private String articulation;
    private int price;
    //    @JsonManagedReference
    @OneToMany(mappedBy = "instanceProduct", orphanRemoval = true)
    private List<ProductAttributeValue> productAttributeValue;
    private int number;
    //    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "id", nullable = true, insertable = false, updatable = false) //cart_id
    private Cart cart;

    public InstanceProduct(String name, String articulation, int price) {
        this.name = name;
        this.articulation = articulation;
        this.price = price;
    }

}
