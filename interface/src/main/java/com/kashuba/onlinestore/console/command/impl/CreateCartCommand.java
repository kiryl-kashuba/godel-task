package com.kashuba.onlinestore.console.command.impl;

public class CreateCartCommand {

    private static CreateCartCommand instance;

    private CreateCartCommand() {
    }

    public static CreateCartCommand getInstance() {
        if (instance == null) {
            instance = new CreateCartCommand();
        }
        return instance;
    }
}
