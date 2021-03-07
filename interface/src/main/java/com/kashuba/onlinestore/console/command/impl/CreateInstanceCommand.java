package com.kashuba.onlinestore.console.command.impl;

public class CreateInstanceCommand {

    private static CreateInstanceCommand instance;

    private CreateInstanceCommand() {
    }

    public static CreateInstanceCommand getInstance() {
        if (instance == null) {
            instance = new CreateInstanceCommand();
        }
        return instance;
    }
}
