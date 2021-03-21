package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.OrderDao;
import com.kashuba.onlinestore.entity.Order;

import java.util.List;

public class OrderDaoImpl extends AbstractCRUDDao<Order> implements OrderDao {

    private static OrderDaoImpl instance;
    private static final String ADD_CATEGORY = "INSERT INTO categories(name)VALUES (?)";
    private static final String REMOVE_CART = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_ALL_CLIENTS = FIND_ALL + " WHERE role = 1";

    private OrderDaoImpl() {
    }

    public static OrderDaoImpl getInstance() {
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }

    @Override
    public Order create(Order order) {

        return order;
    }

    @Override
    public List<Order> delete(int id) {
        return null;
    }

    @Override
    public List<Order> find() {
        return null;
    }
}
