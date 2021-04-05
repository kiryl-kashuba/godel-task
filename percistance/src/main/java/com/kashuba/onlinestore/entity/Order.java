package com.kashuba.onlinestore.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
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
}
