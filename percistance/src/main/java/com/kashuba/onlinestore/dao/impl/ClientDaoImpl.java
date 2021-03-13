package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public class ClientDaoImpl extends AbstractCRUDDao implements ClientDao {

    private static ClientDaoImpl instance;

    private ClientDaoImpl() {
    }

    public static ClientDaoImpl getInstance() {
        if (instance == null) {
            instance = new ClientDaoImpl();
        }
        return instance;
    }

    @Override
    public Client create(Client client) {
        client.setId(IdGenerator.createID());
        fileInitialization.getReadedClients().add(client);
        return client;
    }

    @Override
    public List<Client> delete(int id) {
        fileInitialization.getReadedClients().removeIf(x -> x.getId() == id);
        return fileInitialization.getReadedClients();
    }

    @Override
    public List<Client> find() {
        return fileInitialization.getReadedClients();
    }

}
