package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    private LocalDate dateOrder;
    private int amount;
    @OneToOne(optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
