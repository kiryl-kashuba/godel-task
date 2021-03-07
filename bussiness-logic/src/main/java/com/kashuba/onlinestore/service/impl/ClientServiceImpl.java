package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.dao.impl.ClientDaoImpl;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientDao clientDao = new ClientDaoImpl();


    @Override
    public List<Client> createClient(Client client) {
        return clientDao.createClient(client);
    }

    @Override
    public List<Client> deleteClient(int idClient) {
        return clientDao.deleteClient(idClient);
    }

    @Override
    public List<Client> findClients() {
        return clientDao.findClients();
    }
}
