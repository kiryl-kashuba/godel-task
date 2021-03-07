package com.kashuba.onlinestore.console.command.impl;

public class UpdateInstanceCommand {

    private static UpdateInstanceCommand instance;

    private UpdateInstanceCommand() {
    }

    public static UpdateInstanceCommand getInstance() {
        if (instance == null) {
            instance = new UpdateInstanceCommand();
        }
        return instance;
    }
}
