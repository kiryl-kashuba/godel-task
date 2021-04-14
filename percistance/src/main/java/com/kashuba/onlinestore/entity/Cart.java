package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {

    @OneToMany(mappedBy = "cart", orphanRemoval = true)
    private List<InstanceProduct> instanceProduct;
    //Что тут делать?
//    private List<InstanceProductContainer> number;
//    @JsonBackReference
    @OneToOne(optional = true, mappedBy = "cart", orphanRemoval = true, fetch = FetchType.LAZY)
    private Client client;
    //    @JsonBackReference
    @OneToOne(optional = false, mappedBy = "cart")
    private Order order;
}
