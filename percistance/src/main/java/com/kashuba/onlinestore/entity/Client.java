package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "clients")
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
//(callSuper = true, exclude = {"schedules", "ways", "comments", "tags", "accesses"}) need to add
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property  = "id",
//        scope     = Long.class)
public class Client extends BaseEntity {

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

    //    @Column(name = "dtype")
//    private String dtype;
//    @JsonManagedReference
    @OneToOne(optional = true, mappedBy = "client", orphanRemoval = true, fetch = FetchType.LAZY)
    private Cart cart;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "email")
    @NonNull
    private String email;
    @Column(name = "status")
    private Status status;
    @Column(name = "role")
    @NonNull
    private Role role;
    @Column(name = "password")
    @NonNull
    private String password;
    //    @JsonManagedReference
    @OneToMany(mappedBy = "client", orphanRemoval = true) //, orphanRemoval = true, fetch = FetchType.LAZY
    @JsonIgnore
    private List<Order> orders;

    public Client(String firstName, String secondName, Long phoneNumber,
                  String email, String password, Role role, Status status) {
        this.email = email;
        this.role = role;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
//        this.cart = cart;
        this.status = status;
    }

    public enum Role {
        GUEST("guest"),
        CLIENT("client"),
        ADMIN("admin");

        private final String valueOfRole;

        Role(String valueOfRole) {
            this.valueOfRole = valueOfRole;
        }

        public static Role getUserRole(int index) {
            return Arrays.stream(Role.values()).filter(r -> r.ordinal() == index).findFirst().get();
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
}
