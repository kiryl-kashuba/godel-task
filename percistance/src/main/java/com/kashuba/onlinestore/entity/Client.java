package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client extends BaseEntity {

    @JsonManagedReference
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = true)
    private Cart cart;
    @JsonManagedReference
    @OneToMany(mappedBy = "client", orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Order> orders;

    public enum Status {
        ACTIVE("ACTIVE"),
        BLOCKED("BLOCKED");

        private final String valueOfStatus;

        Status(String value) {
            this.valueOfStatus = value;
        }

        public String getValue() {
            return valueOfStatus;
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

    public enum Role {
        GUEST("GUEST"),
        CLIENT("CLIENT"),
        ADMIN("ADMIN");

        private final String valueOfRole;

        Role(String valueOfRole) {
            this.valueOfRole = valueOfRole;
        }

        public static Role findRole(String role) {
            Role user = null;
            for (Role env : Role.values()) {
                if (role.equals(env.getvalueOfRole())) {
                    user = env;
                }
            }
            return user;
        }

        public String getvalueOfRole() {
            return valueOfRole;
        }
    }

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "email")
    @NonNull
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NonNull
    private Status status;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @NonNull
    private Role role;
    @Column(name = "password")
    @NonNull
    private String password;

    public Client(String firstName, String secondName, Long phoneNumber,
                  String email, String password) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }
}
