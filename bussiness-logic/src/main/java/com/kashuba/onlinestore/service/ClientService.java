package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    void deleteClient(long idClient);

    List<Client> findClients();

}
