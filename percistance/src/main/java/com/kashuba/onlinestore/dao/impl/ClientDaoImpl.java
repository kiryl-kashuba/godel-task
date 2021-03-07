package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.entity.Client;

import java.io.IOException;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    @Override
    public List<Client> createClient(Client client, List<Client> readedClients) {
        readedClients.add(client);
        return readedClients;
    }

    @Override
    public List<Client> deleteClient(int idClient, List<Client> readedClients) {
        readedClients.removeIf(x -> x.getId() == idClient);
        return readedClients;
    }

    @Override
    public List<Client> findClients(List<Client> readedClients) {
        return readedClients;
    }

}
