package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.entity.BaseEntity;
import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public class ClientDaoImpl extends CRUDDao {

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
    public List<Client> create(BaseEntity object) {
        object.setId(IdGenerator.createID());
        fileInitialization.getReadedClients().add((Client) object);
        return fileInitialization.getReadedClients();
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
