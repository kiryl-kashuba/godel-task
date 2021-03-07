package com.kashuba.onlinestore.console.command.impl;

public class FindCartCommand {

    private static FindCartCommand instance;

    private FindCartCommand() {
    }

    public static FindCartCommand getInstance() {
        if (instance == null) {
            instance = new FindCartCommand();
        }
        return instance;
    }
}
