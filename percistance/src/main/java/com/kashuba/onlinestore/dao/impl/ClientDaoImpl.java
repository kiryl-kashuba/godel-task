package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public class ClientDaoImpl implements ClientDao {

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
    public List<Client> createClient(Client client) {
        client.setId(IdGenerator.createID());
        FileInitialization.getInstance().getReadedClients().add(client);
        return FileInitialization.getInstance().getReadedClients();
    }

    @Override
    public List<Client> deleteClient(int idClient) {
        FileInitialization.getInstance().getReadedClients().removeIf(x -> x.getId() == idClient);
        return FileInitialization.getInstance().getReadedClients();
    }

    @Override
    public List<Client> findClients() {
        return FileInitialization.getInstance().getReadedClients();
    }

}
