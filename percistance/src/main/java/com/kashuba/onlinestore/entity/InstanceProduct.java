package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instance_products")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class InstanceProduct extends BaseEntity {

    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    private String name;
    private String articulation;
    private Long price;
    @JsonIgnore
    @OneToMany(mappedBy = "instanceProduct", orphanRemoval = true)
    private List<ProductAttributeValue> productAttributeValue;
    private Long number;
    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(name = "cart_id", nullable = true)
    private Cart cart;

    public InstanceProduct(String name, String articulation, Long price) {
        this.name = name;
        this.articulation = articulation;
        this.price = price;
    }

}
