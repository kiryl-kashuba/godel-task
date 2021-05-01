package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "cart", orphanRemoval = true)
    private List<InstanceProduct> instanceProduct;
    @JsonBackReference
    @OneToOne(optional = true, mappedBy = "cart", orphanRemoval = true, fetch = FetchType.LAZY)
    private Client client;
    @JsonBackReference
    @OneToOne(optional = true, mappedBy = "cart")
    private Order order;
}
