package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClientService {

    List<Client> createClient(Client client);

    List<Client> deleteClient(int idClient);

    List<Client> findClients();

}
