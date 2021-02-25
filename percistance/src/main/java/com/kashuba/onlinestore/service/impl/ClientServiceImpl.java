package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.dao.impl.ClientDaoImpl;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientDao clientDao = new ClientDaoImpl();

    @Override
    public Client add(Client client) {
            clientDao.add(client);
        System.out.println("Service " + client);
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public Client removeClient(Client client) {
        return null;
    }

    @Override
    public Client findClients(Client client) {
        return null;
    }

    @Override
    public Client updateClientStatus(Client updatingClient, String statusData) {
        return null;
    }

    @Override
    public List<Client> findClientsById(String clientIdData) {
        return null;
    }
}
