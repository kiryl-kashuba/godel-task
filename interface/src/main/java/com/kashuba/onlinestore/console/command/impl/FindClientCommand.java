package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public class FindClientCommand {

    private static FindClientCommand instance;

    private FindClientCommand() {
    }

    public static FindClientCommand getInstance() {
        if (instance == null) {
            instance = new FindClientCommand();
        }
        return instance;
    }

    public List<Client> findCLients() {
        return readedClients;
    }

}
