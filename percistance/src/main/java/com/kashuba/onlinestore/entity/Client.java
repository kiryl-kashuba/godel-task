package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "clients")
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
//(callSuper = true, exclude = {"schedules", "ways", "comments", "tags", "accesses"}) need to add
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {

    @Column(name = "phone_number")
    private Long phoneNumber;

    public enum Status {
        @Column(name = "role") // Как обозначить Enum в таблице?
        ACTIVE("active"),
        @Column(name = "role") // Как обозначить Enum в таблице?
        BLOCKED("blocked");

        private final String valueOfStatus;

        Status(String value) {
            this.valueOfStatus = value;
        }

        public String getValue() {
            return valueOfStatus;
        }

        public static Status getClientStatus(int index) {
            return Arrays.stream(Status.values()).filter(s -> s.ordinal() == index).findFirst().get();
        }

        public static Client.Status findStatus(String status) {
            Client.Status user = null;
            for (Client.Status env : Client.Status.values()) {
                if (status.equals(env.getValue())) {
                    user = env;
                }
            }
            return user;
        }
    }

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @OneToOne(optional = true, cascade = CascadeType.ALL) //false
    @JoinColumn(name = "cart_id", nullable = false) //false
    private Cart cart;
    @Column(name = "status")
    private Status status;

    public Client(String firstName, String secondName, Long phoneNumber, Cart cart, String email, String password, Role role, Status status) {
        super(email, role, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.cart = cart;
        this.status = status;
    }

}
