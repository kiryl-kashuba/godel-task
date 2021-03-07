package com.kashuba.onlinestore.console.command.impl;

public class FindInstanceCommand {

    private static FindInstanceCommand instance;

    private FindInstanceCommand() {
    }

    public static FindInstanceCommand getInstance() {
        if (instance == null) {
            instance = new FindInstanceCommand();
        }
        return instance;
    }
}
