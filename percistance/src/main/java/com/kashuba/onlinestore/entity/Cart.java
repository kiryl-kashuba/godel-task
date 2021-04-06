package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {

    @OneToMany(mappedBy = "cart")
    private List<InstanceProduct> instanceProduct;
    //Что тут делать?
//    private List<InstanceProductContainer> number;
    @OneToOne(optional = false, mappedBy = "cart")
    private Client client;
    @OneToOne(optional = false, mappedBy = "cart")
    private Order order;

    public Cart(long id, Client client, List<InstanceProduct> instanceProduct) {
        super(id);
        this.client = client;
        this.instanceProduct = instanceProduct;
    }

    public Cart(List<InstanceProduct> instanceProduct) {
        this.instanceProduct = instanceProduct;
    }

    public Cart(long id, Client client) {
        super(id);
        this.client = client;
    }

    public Cart(long id, List<InstanceProduct> instanceProduct) {
        super(id);
        this.instanceProduct = instanceProduct;
    }

    public Cart(long id) {
        super(id);
    }


    public List<InstanceProduct> addInstanceProduct(InstanceProduct instanceProduct) {
        this.instanceProduct.add(instanceProduct);
        return this.instanceProduct;
    }
}
