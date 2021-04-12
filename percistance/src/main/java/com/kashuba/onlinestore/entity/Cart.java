package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "carts")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {

    @OneToMany(mappedBy = "cart")
    private List<InstanceProduct> instanceProduct;
    //Что тут делать?
//    private List<InstanceProductContainer> number;
    @OneToOne(optional = true, mappedBy = "cart")
    private Client client;
    @OneToOne(optional = true, mappedBy = "cart")
    private Order order;
}
