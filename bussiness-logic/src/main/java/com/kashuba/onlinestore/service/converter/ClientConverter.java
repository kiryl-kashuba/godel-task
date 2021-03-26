package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {

    public Client toModel(ClientDto clientDto) {
        Client client = new Client(clientDto.getEmail(), clientDto.getPassword()); // допишу

        return null;
    }

    public ClientDto toDto(Client client) {

        return null;
    }
}
