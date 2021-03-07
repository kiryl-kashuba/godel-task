package com.kashuba.onlinestore.console.command.impl;

public class FindProductAttributeCommand {

    private static FindProductAttributeCommand instance;

    private FindProductAttributeCommand() {
    }

    public static FindProductAttributeCommand getInstance() {
        if (instance == null) {
            instance = new FindProductAttributeCommand();
        }
        return instance;
    }
}
