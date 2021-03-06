package com.kashuba.onlinestore.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Order extends BaseEntity {

    private LocalDate dateOrder;
    private int amount;
    private Cart cart;

    public Order(long id, LocalDate dateOrder) {
        super(id);
        this.dateOrder = dateOrder;
    }

    public Order(long id, LocalDate dateOrder, Cart cart) {
        super(id);
        this.dateOrder = dateOrder;
        this.cart = cart;
    }

    public Order(long id, LocalDate dateOrder, int amount, Cart cart) {
        super(id);
        this.dateOrder = dateOrder;
        this.amount = amount;
        this.cart = cart;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
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
                "dateOrder=" + dateOrder +
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
                Objects.equals(dateOrder, order.dateOrder) &&
                Objects.equals(cart, order.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOrder, amount, cart);
    }
}
