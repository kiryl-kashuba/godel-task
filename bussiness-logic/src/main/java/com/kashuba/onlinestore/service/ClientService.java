package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.dto.ClientDto;

import java.util.List;

public interface ClientService {

    Client createClient(ClientDto clientDto);

    void deleteClient(Client client);

    List<Client> findClients();

}
