package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class Cart {

    private long id;
    private int number;
    private Client client;
    private InstanceProduct instanceProduct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id &&
                number == cart.number &&
                Objects.equals(client, cart.client) &&
                Objects.equals(instanceProduct, cart.instanceProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, client, instanceProduct);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", number=" + number +
                ", client=" + client +
                ", instanceProduct=" + instanceProduct +
                '}';
    }
}
