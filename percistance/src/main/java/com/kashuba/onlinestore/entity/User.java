package com.kashuba.onlinestore.entity;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;
import java.util.Objects;

public class User extends BaseEntity {

    public User(long id, String email, Role role, String password) {
        super(id);
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public enum Role {
        GUEST,
        CLIENT,
        ADMIN;
    }
    private String email;
    private Role role;
    private String password;


    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                role == user.role &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, role, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
