package com.kashuba.onlinestore.console.command.impl;

public class AddInstanceToCartCommand {

    private static AddInstanceToCartCommand instance;

    private AddInstanceToCartCommand() {
    }

    public static AddInstanceToCartCommand getInstance() {
        if (instance == null) {
            instance = new AddInstanceToCartCommand();
        }
        return instance;
    }

}
