package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
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
//    @Column(name = "cart")
    private Cart cart;

    public Client(String email, Role role, String password, String firstName,
                  String secondName, long phoneNumber, Status status) {
        super(email, role, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public Client(String email, String password, String firstName, String secondName, long phoneNumber) {
        super(email, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }
}
