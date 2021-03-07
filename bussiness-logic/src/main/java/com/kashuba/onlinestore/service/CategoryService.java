package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;


import java.util.List;
import java.util.Map;

public interface CategoryService {

    Client add(Client client);

    Client updateClient(Client client);

    Client removeClient(Client client);

    Client findClients(Client client);

    Client updateClientStatus(Client updatingClient, String statusData);

    List<Client> findClientsById(String clientIdData);
}
