package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.UserDao;
import com.kashuba.onlinestore.entity.User;

import java.util.List;

public class UserDaoImpl extends AbstractCRUDDao<User> implements UserDao {

    private static UserDaoImpl instance;
    private static final String ADD_CATEGORY = "INSERT INTO categories(name)VALUES (?)";
    private static final String REMOVE_CART = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_ALL_CLIENTS = FIND_ALL + " WHERE role = 1";

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public User create(User user) {
//        fileInitialization.getReadedUser().add(user);
        return user;
    }

    @Override
    public List<User> delete(int id) {
//        fileInitialization.getReadedUser().removeIf(x -> x.getId() == id);
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
