package com.kashuba.onlinestore.console.command.impl;

public class CreateOrderCommand {

    private static CreateOrderCommand instance;

    private CreateOrderCommand() {
    }

    public static CreateOrderCommand getInstance() {
        if (instance == null) {
            instance = new CreateOrderCommand();
        }
        return instance;
    }
}
