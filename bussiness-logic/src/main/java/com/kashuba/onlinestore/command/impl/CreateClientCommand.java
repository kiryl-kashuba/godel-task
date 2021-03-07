package com.kashuba.onlinestore.command.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.command.ActionCommand;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.service.ClientService;
import com.kashuba.onlinestore.service.impl.ClientServiceImpl;

import java.util.List;

public class CreateClientCommand{
    public List<Client> createCLient(String email, String pass, String fname, String sname, long number, List<Client> readedClients) {
        ClientService clientService = new ClientServiceImpl();
        return clientService.createClient(email, pass, fname, sname, number, readedClients);
    }


}
