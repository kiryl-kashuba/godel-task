package com.kashuba.onlinestore.service.impl;

public class CartServiceImpl {

    private static CartServiceImpl instance;

    private CartServiceImpl() {
    }

    public static CartServiceImpl getInstance() {
        if (instance == null) {
            instance = new CartServiceImpl();
        }
        return instance;
    }
}
