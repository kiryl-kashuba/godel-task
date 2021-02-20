package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class Client {

    public enum Status {
        ACTIVE,
        BLOCKED;

        //getClientStatus
    }

    private String firstName;
    private String secondName;
    private long phoneNumber;
    private Status status;

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
                ", phoneNumber=" + phoneNumber +
                ", status=" + status +
                '}';
    }
}
