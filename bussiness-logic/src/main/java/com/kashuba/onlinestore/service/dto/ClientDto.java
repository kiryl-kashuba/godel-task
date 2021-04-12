package com.kashuba.onlinestore.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kashuba.onlinestore.entity.Cart;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto extends BaseEntityDto {
    private String firstName;
    private String secondName;
    private Long phoneNumber;
    private String email;
    private String password;
    private String status;
    private Cart cart;
    private String role;
//    private Client.Status status;
//    private Cart cart;
}
