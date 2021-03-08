package com.kashuba.onlinestore.dao.impl;

public class CartDaoImpl {

    private static CartDaoImpl instance;

    private CartDaoImpl() {
    }

    public static CartDaoImpl getInstance() {
        if (instance == null) {
            instance = new CartDaoImpl();
        }
        return instance;
    }
}
