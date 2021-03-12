package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    List<Client> deleteClient(int idClient);

    List<Client> findClients();

}
