package com.kashuba.onlinestore.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Order extends BaseEntity {

    private LocalDate localDate;
    private int amount;
    private Cart cart;

    public Order(LocalDate localDate, int amount, Cart cart, long id) {
        super(id);
        this.localDate = localDate;
        this.amount = amount;
        this.cart = cart;
    }


    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id='" + super.getId() + '\'' +
                "localDate=" + localDate +
                ", amount=" + amount +
                ", cart=" + cart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return amount == order.amount &&
                Objects.equals(localDate, order.localDate) &&
                Objects.equals(cart, order.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), localDate, amount, cart);
    }
}
