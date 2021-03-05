package com.kashuba.onlinestore.entity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Cart extends BaseEntity{

    private Client client;
    private List<InstanceProduct> instanceProduct;
    private Map<InstanceProduct, Integer> number;

    public Cart(long id, Client client, List<InstanceProduct> instanceProduct) {
        super(id);
        this.client = client;
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

    public List<InstanceProduct> addInstanceProduct (InstanceProduct instanceProduct){
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

    public Map<InstanceProduct, Integer> getNumber() {
        return number;
    }

    public void setNumber(Map<InstanceProduct, Integer> number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "Id='" + super.getId() + '\'' +
                "client=" + client +
                ", instanceProduct=" + instanceProduct +
                ", number=" + number +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(client, cart.client) &&
                Objects.equals(instanceProduct, cart.instanceProduct) &&
                Objects.equals(number, cart.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), client, instanceProduct, number);
    }
}
