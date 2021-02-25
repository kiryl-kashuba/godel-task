package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.exeption.ServiceProjectException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClientService {

    Client add(Client client);

    Client updateClient(Client client);

    Client removeClient(Client client);

    Client findClients(Client client);

    Client updateClientStatus(Client updatingClient, String statusData);

    List<Client> findClientsById(String clientIdData);
}
