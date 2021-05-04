package com.kashuba.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto extends BaseEntityDto {
    @NotNull(message = "FirstName must not be null")
    @Size(max = 15, message = "Name must not be longer than 15 characters")
    private String firstName;
    @NotNull(message = "SecondName must not be null")
    @Size(max = 15, message = "Name must not be longer than 15 characters")
    private String secondName;
    @Size(min = 6, max = 15, message = "Name must be between 6 and 15 characters long")
    private Long phoneNumber;
    @Email
    private String email;
    @Size(min = 5, max = 60, message = "Password must be between 5 and 60 characters long")
    private String password;

    public ClientDto(String secondName, Long phoneNumber, String email, String firstName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}