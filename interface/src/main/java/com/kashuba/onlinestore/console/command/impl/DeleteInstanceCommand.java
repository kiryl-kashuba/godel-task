package com.kashuba.onlinestore.console.command.impl;

public class DeleteInstanceCommand {

    private static DeleteInstanceCommand instance;

    private DeleteInstanceCommand() {
    }

    public static DeleteInstanceCommand getInstance() {
        if (instance == null) {
            instance = new DeleteInstanceCommand();
        }
        return instance;
    }
}
