package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.impl.ClientServiceImpl;

public class CreateClientCommand {

    private static CreateClientCommand instance;
    private ClientServiceImpl clientService = ClientServiceImpl.getInstance();

    private CreateClientCommand() {
    }

    public static CreateClientCommand getInstance() {
        if (instance == null) {
            instance = new CreateClientCommand();
        }
        return instance;
    }


    public Client createCLient(Client client) {
        return clientService.createClient(client);
    }


}
