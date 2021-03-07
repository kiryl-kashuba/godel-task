package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public interface ProductAttributeService {
    Client add(Client client);

    Client updateClient(Client client);

    Client removeClient(Client client);

    Client findClients(Client client);

    Client updateClientStatus(Client updatingClient, String statusData);

    List<Client> findClientsById(String clientIdData);
}
