package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.dao.impl.ClientDaoImpl;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.service.ClientService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientDao clientDao = new ClientDaoImpl();


    @Override
    public List<Client> createClient(String email, String pass, String fname, String sname, long number, List<Client> readedClients) {
        ClientDao clientDao = new ClientDaoImpl();
        User.Role role = User.Role.CLIENT;
        Client.Status status = Client.Status.ACTIVE;
        long id = IdGenerator.createID();
        Client client = new Client(email, role, pass, id, fname, sname, number, status);
        return clientDao.createClient(client, readedClients);
    }

    @Override
    public List<Client> deleteClient(int idClient, List<Client> readedClients) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.deleteClient(idClient, readedClients);
    }

    @Override
    public List<Client> findClients(List<Client> readedClients) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.findClients(readedClients);
    }
}
