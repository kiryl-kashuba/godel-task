package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.impl.ClientServiceImpl;

import java.util.List;

public class CreateClientCommand {

    private static CreateClientCommand instance;

    private CreateClientCommand() {
    }

    public static CreateClientCommand getInstance() {
        if (instance == null) {
            instance = new CreateClientCommand();
        }
        return instance;
    }

    ClientServiceImpl clientService = ClientServiceImpl.getInstance();

    public List<Client> createCLient(Client client) {
        return clientService.createClient(client);
    }


}
