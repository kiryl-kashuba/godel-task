package com.kashuba.onlinestore.console.command.impl;

public class DeleteCartCommand {

    private static DeleteCartCommand instance;

    private DeleteCartCommand() {
    }

    public static DeleteCartCommand getInstance() {
        if (instance == null) {
            instance = new DeleteCartCommand();
        }
        return instance;
    }
}
