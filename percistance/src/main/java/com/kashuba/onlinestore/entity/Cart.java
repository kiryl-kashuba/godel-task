package com.kashuba.onlinestore.entity;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Cart extends BaseEntity {

    private Client client;
    private List<InstanceProduct> instanceProduct;
    private List<InstanceProductContainer> number;

    public Cart(long id, Client client, List<InstanceProduct> instanceProduct) {
        super(id);
        this.client = client;
        this.instanceProduct = instanceProduct;
    }

    public Cart(List<InstanceProduct> instanceProduct, List<InstanceProductContainer> number) {
        this.instanceProduct = instanceProduct;
        this.number = number;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<InstanceProduct> getInstanceProduct() {
        return instanceProduct;
    }

    public void setInstanceProduct(List<InstanceProduct> instanceProduct) {
        this.instanceProduct = instanceProduct;
    }

    public List<InstanceProductContainer> getNumber() {
        return number;
    }

    public void setNumber(List<InstanceProductContainer> number) {
        this.number = number;
    }
}
