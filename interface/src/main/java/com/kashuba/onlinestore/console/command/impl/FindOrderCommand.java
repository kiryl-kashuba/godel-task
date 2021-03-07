package com.kashuba.onlinestore.console.command.impl;

public class FindOrderCommand {

    private static FindOrderCommand instance;

    private FindOrderCommand() {
    }

    public static FindOrderCommand getInstance() {
        if (instance == null) {
            instance = new FindOrderCommand();
        }
        return instance;
    }
}
