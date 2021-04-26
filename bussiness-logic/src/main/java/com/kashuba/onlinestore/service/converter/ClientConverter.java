package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.dto.ClientDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientConverter {

    public Client toModel(ClientDto clientDto) {
        return new Client(clientDto.getFirstName(), clientDto.getSecondName(), clientDto.getPhoneNumber(),
                clientDto.getEmail(), clientDto.getPassword());
    }

    public ClientDto toDto(Client client) {
        return new ClientDto(client.getSecondName(), client.getPhoneNumber(), client.getEmail(),
                client.getFirstName(), client.getRole(), client.getStatus());
    }

    public Optional<ClientDto> toOptionalDto(Optional<Client> client) {
        ClientDto clientDto = new ClientDto(client.get().getSecondName(), client.get().getPhoneNumber(),
                client.get().getEmail(), client.get().getFirstName(), client.get().getRole(),
                client.get().getStatus());
        return Optional.of(clientDto);
    }

    public List<ClientDto> toListDto(List<Client> clientList) {
        List<ClientDto> clientDtos = new ArrayList<>();
        for (Client client : clientList) {
            clientDtos.add(new ClientDto(client.getSecondName(), client.getPhoneNumber(), client.getEmail(),
                    client.getFirstName(), client.getRole(), client.getStatus()));
        }
        return clientDtos;
    }
}
