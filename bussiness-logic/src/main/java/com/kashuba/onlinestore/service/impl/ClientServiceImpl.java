package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.ClientDaoImpl;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDaoImpl clientDao = ClientDaoImpl.getInstance();

    private static ClientServiceImpl instance;

    private ClientServiceImpl() {
    }

    public static ClientServiceImpl getInstance() {
        if (instance == null) {
            instance = new ClientServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Client> createClient(Client client) {
        return clientDao.create(client);
    }

    @Override
    public List<Client> deleteClient(int id) {
        return clientDao.delete(id);
    }

    @Override
    public List<Client> findClients() {
        return clientDao.find();
    }
}
