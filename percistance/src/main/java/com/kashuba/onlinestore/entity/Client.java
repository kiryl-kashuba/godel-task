package com.kashuba.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "clients")
@Data
@EqualsAndHashCode //(callSuper = true, exclude = {"schedules", "ways", "comments", "tags", "accesses"}) need to add
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {

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
    @Column(name = "phone_number")
    private long phoneNumber;
    @Column(name = "status")
    private Status status;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
