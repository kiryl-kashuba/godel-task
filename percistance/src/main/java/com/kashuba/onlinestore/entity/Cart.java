package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {

    @OneToMany(mappedBy = "cart", orphanRemoval = true)
    private List<InstanceProduct> instanceProduct;
    //Что тут делать?
//    private List<InstanceProductContainer> number;
    @JsonBackReference
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = true)
    private Client client;
    @JsonBackReference
    @OneToOne(optional = true, mappedBy = "cart")
    private Order order;
}
