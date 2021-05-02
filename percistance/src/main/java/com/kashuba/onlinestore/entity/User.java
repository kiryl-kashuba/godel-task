package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.util.Arrays;

@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
@Data

public class User {

    public User(String email, String password) {
        this.password = password;
        this.email = email;
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
    @NonNull
    private String email;
    @Column(name = "role")
    @NonNull
    private Role role;
    @Column(name = "password")
    @NonNull
    private String password;
}
