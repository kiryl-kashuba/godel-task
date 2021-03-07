package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import com.kashuba.onlinestore.service.impl.ClientServiceImpl;

import java.util.List;

public class DeleteClientCommand {

    public List<Client> deleteCLient(int idClient, List<Client> readedClients) {
        ClientService clientService = new ClientServiceImpl();
        clientService.deleteClient(idClient, readedClients);
        readedClients.removeIf(x -> x.getId() == idClient);
        return readedClients;

}
}
