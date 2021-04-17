package com.kashuba.onlinestore.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property  = "id",
//        scope     = Long.class)
public class Order extends BaseEntity {

    @OneToOne(optional = false)
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false) //cart_id
    private Cart cart;

    @CreatedDate
    private LocalDate dateOrder;
    private int amount;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false) //client_id
//    @JsonBackReference
//    @JsonIgnore
    private Client client;

    public Order(LocalDate dateOrder, int amount) {
        this.dateOrder = dateOrder;
        this.amount = amount;
    }
}
