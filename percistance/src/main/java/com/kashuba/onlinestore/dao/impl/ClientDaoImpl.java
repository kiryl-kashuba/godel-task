package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.dao.csv.ClientCsv;
import com.kashuba.onlinestore.entity.Client;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    ClientCsv clientCsv = new ClientCsv();

    @Override
    public Client add(Client client) {
        try {
            System.out.println("Dao" + client);
            clientCsv.writeClient(client);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
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
