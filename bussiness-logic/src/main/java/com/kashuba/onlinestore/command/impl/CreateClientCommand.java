package com.kashuba.onlinestore.command.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.command.ActionCommand;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;

import java.util.List;

public class CreateClientCommand{
    public List<Client> createCLient(String email, String pass, String fname, String sname, long number, List readedClients) {
        User.Role role = User.Role.CLIENT;
        Client.Status status = Client.Status.ACTIVE;
        long id = IdGenerator.createID();
        Client client = new Client(email, role, pass, id, fname, sname, number, status);
        readedClients.add(client);
        return readedClients;
    }


}
