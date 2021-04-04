package com.kashuba.onlinestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class User extends BaseEntity {

    public User(String email, Role role, String password) {
        super();
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public enum Role {
        GUEST("guest"),
        CLIENT("client"),
        ADMIN("admin");

        private final String valueOfRole;

        Role(String valueOfRole) {
            this.valueOfRole = valueOfRole;
        }

        public String getvalueOfRole() {
            return valueOfRole;
        }

        public static Role getUserRole(int index) {
            return Arrays.stream(Role.values()).filter(r -> r.ordinal() == index).findFirst().get();
        }

        public static User.Role findRole(String role) {
            User.Role user = null;
            for (User.Role env : User.Role.values()) {
                if (role.equals(env.getvalueOfRole())) {
                    user = env;
                }
            }
            return user;
        }
    }

    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private Role role;
    @Column(name = "password")
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
                "Id='" + super.getId() + '\'' +
                "email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
