package com.kashuba.onlinestore.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kashuba.onlinestore.entity.Client;
import lombok.*;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto extends BaseEntityDto {
    @NotBlank(message = "firstName is mandatory")
    private String firstName;
    @NotBlank(message = "secondName is mandatory")
    private String secondName;
    @NotBlank(message = "phoneNumber is mandatory")
    private Long phoneNumber;
    @NotBlank(message = "email is mandatory")
    private String email;
    @NotBlank(message = "password is mandatory")
    private String password;
    private String status;
    private String role;

    public ClientDto(String secondName, Long phoneNumber, String email, String firstName,
                     Client.Role role, Client.Status status) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status.getValue();
        this.role = role.getvalueOfRole();
    }
}