package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import com.kashuba.onlinestore.service.impl.ClientServiceImpl;

import java.util.List;

public class DeleteClientCommand {

    private static DeleteClientCommand instance;

    private DeleteClientCommand() {
    }

    public static DeleteClientCommand getInstance() {
        if (instance == null) {
            instance = new DeleteClientCommand();
        }
        return instance;
    }

    ClientService clientService = new ClientServiceImpl();

    public List<Client> deleteCLient(int idClient, List<Client> readedClients) {
        clientService.deleteClient(idClient);
        readedClients.removeIf(x -> x.getId() == idClient);
        return readedClients;

    }
}
