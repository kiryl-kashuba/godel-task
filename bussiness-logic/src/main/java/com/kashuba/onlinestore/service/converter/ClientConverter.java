package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.service.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {

    public Client toModel(ClientDto clientDto) {
        return new Client(clientDto.getFirstName(), clientDto.getSecondName(), clientDto.getPhoneNumber(),
                clientDto.getCart(), clientDto.getEmail(), clientDto.getPassword(),
                User.Role.findRole(clientDto.getRole()), Client.Status.findStatus(clientDto.getStatus()));
    }

    public ClientDto toDto(Client client) {
        return new ClientDto();
    }
}
