package com.kashuba.onlinestore.console.command.impl;

public class DeleteOrderCommand {

    private static DeleteOrderCommand instance;

    private DeleteOrderCommand() {
    }

    public static DeleteOrderCommand getInstance() {
        if (instance == null) {
            instance = new DeleteOrderCommand();
        }
        return instance;
    }
}
