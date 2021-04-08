package com.kashuba.onlinestore.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto extends BaseEntityDto {
    private String firstName;
    private String secondName;
    private long phoneNumber;
    private String email;
    private String password;
//    private Client.Status status;
//    private Cart cart;
}
