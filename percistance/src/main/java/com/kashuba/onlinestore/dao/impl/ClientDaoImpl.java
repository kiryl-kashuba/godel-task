package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public class ClientDaoImpl implements ClientDao {
    FileInitialization fileInitialization = new FileInitialization();

    @Override
    public List<Client> createClient(Client client) {
        client.setId(IdGenerator.createID());
        fileInitialization.getReadedClients().add(client);
        return fileInitialization.getReadedClients();
    }

    @Override
    public List<Client> deleteClient(int idClient) {
        fileInitialization.getReadedClients().removeIf(x -> x.getId() == idClient);
        return fileInitialization.getReadedClients();
    }

    @Override
    public List<Client> findClients() {
        return fileInitialization.getReadedClients();
    }

}
