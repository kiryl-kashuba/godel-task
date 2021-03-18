package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.CartDao;
import com.kashuba.onlinestore.entity.Cart;

import java.util.List;

public class CartDaoImpl extends AbstractCRUDDao<Cart> implements CartDao {

    private static CartDaoImpl instance;
    private static final String ADD_CATEGORY = "INSERT INTO categories(name)VALUES (?)";
    private static final String REMOVE_CART = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_ALL_CLIENTS = FIND_ALL + " WHERE role = 1";

    private CartDaoImpl() {
    }

    public static CartDaoImpl getInstance() {
        if (instance == null) {
            instance = new CartDaoImpl();
        }
        return instance;
    }


    @Override
    public Cart create(Cart cart) {
        return null;
    }

    @Override
    public List<Cart> delete(int id) {
        return null;
    }

    @Override
    public List<Cart> find() {
        return null;
    }


    @Override
    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        Cart returnCart = null;

        return returnCart;
    }

}