package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Client;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public interface ClientDao {

    Client add(Client client);

    Client updateClient(Client client);

    Client removeClient(Client client);

    Client findClients(Client client);

    Client updateClientStatus(Client updatingClient, String statusData);

    List<Client> findClientsById(String clientIdData);
}
