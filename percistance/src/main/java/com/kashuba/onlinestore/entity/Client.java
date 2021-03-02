package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class Client extends User {

    public enum Status {
        ACTIVE,
        BLOCKED;

        //getClientStatus
    }

    private String firstName;
    private String secondName;
    private long phoneNumber;
    private Status status;

    public Client(String email, Role role, String password, long id, String firstName,
                  String secondName, long phoneNumber, Status status) {
        super(id, email, role, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.status = status;
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
        Client client = (Client) o;
        return phoneNumber == client.phoneNumber &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(secondName, client.secondName) &&
                status == client.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, phoneNumber, status);
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber=" + phoneNumber + '\'' +
                ", status=" + status + '\'' +
                ", Email='" + super.getEmail() + '\'' +
                ", Id='" + super.getId() + '\'' +
                ", Password='" + super.getPassword() + '\'' +
                ", Role='" + super.getRole() + '\'' +
                '}';
    }
}
