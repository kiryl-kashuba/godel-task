package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {

    public Client toModel(ClientDto clientDto) {
        return new Client(clientDto.getEmail(), clientDto.getPassword(),
                clientDto.getFirstName(), clientDto.getSecondName(), clientDto.getPhoneNumber());
    }

    public ClientDto toDto(Client client) {
        return new ClientDto(client.getEmail(), client.getPassword(), client.getFirstName(),
                client.getSecondName(), client.getPhoneNumber());
    }
}
