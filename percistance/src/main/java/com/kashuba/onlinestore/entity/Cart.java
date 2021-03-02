package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class Cart extends BaseEntity{

    private int number;
    private Client client;
    private InstanceProduct instanceProduct;

    public Cart(int number, Client client, InstanceProduct instanceProduct, long id) {
        super(id);
        this.number = number;
        this.client = client;
        this.instanceProduct = instanceProduct;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public InstanceProduct getInstanceProduct() {
        return instanceProduct;
    }

    public void setInstanceProduct(InstanceProduct instanceProduct) {
        this.instanceProduct = instanceProduct;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "number=" + number +
                ", client=" + client +
                ", instanceProduct=" + instanceProduct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cart cart = (Cart) o;
        return number == cart.number &&
                Objects.equals(client, cart.client) &&
                Objects.equals(instanceProduct, cart.instanceProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number, client, instanceProduct);
    }
}
