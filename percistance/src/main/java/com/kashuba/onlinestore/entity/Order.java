package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    @OneToOne(optional = true)
    @JoinColumn(name = "id", nullable = true)
    private Cart cart;

    @CreatedDate
    private LocalDate dateOrder;
    private int amount;
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
//    @JsonIgnore
    private Client client;
}
