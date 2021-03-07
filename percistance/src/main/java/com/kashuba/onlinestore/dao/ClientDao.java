package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Client;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public interface ClientDao {

    List<Client> createClient(Client client);

    List<Client> deleteClient(int idClient);

    List<Client> findClients();

}
