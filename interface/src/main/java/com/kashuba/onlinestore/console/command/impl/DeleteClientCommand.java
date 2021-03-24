package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.service.impl.ClientServiceImpl;

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


    public void deleteCLient(long idClient) {
        clientService.deleteClient(idClient);
    }
}
