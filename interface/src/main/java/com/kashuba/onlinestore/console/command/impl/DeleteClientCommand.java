package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.impl.ClientServiceImpl;

import java.util.List;

public class DeleteClientCommand {

    private static DeleteClientCommand instance;
    private ClientServiceImpl clientService = ClientServiceImpl.getInstance();

    private DeleteClientCommand() {
    }

    public static DeleteClientCommand getInstance() {
        if (instance == null) {
            instance = new DeleteClientCommand();
        }
        return instance;
    }


    public List<Client> deleteCLient(int idClient) {
        return clientService.deleteClient(idClient);
    }
}
