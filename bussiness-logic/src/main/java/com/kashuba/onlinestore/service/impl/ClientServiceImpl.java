package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.dao.impl.ClientDaoImpl;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientDao clientDao = new ClientDaoImpl();


    @Override
    public List<Client> createClient(String email, String pass, String fname, String sname, long number, List<Client> readedClients) {
        User.Role role = User.Role.CLIENT;
        Client.Status status = Client.Status.ACTIVE;
        Client client = new Client(email, role, pass, fname, sname, number, status);
        return clientDao.createClient(client, readedClients);
    }

    @Override
    public List<Client> deleteClient(int idClient, List<Client> readedClients) {
        return clientDao.deleteClient(idClient, readedClients);
    }

    @Override
    public List<Client> findClients(List<Client> readedClients) {
        return clientDao.findClients(readedClients);
    }
}
