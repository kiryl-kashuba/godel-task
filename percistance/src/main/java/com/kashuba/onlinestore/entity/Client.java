package com.kashuba.onlinestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "clients")
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

    public Client() {

    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return phoneNumber == client.phoneNumber &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(secondName, client.secondName) &&
                status == client.status &&
                Objects.equals(cart, client.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, secondName, phoneNumber, status, cart);
    }

    @Override
    public String toString() {
        return "Client{" +
                "Id='" + super.getId() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber=" + phoneNumber + '\'' +
                ", status=" + status + '\'' +
                ", Email='" + super.getEmail() + '\'' +
                ", Password='" + super.getPassword() + '\'' +
                ", Role='" + super.getRole() + '\'' +
                '}';
    }
}
