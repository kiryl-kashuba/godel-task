package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.UserDao;
import com.kashuba.onlinestore.entity.User;

import java.util.List;

public class UserDaoImpl extends AbstractCRUDDao<User> implements UserDao {

    private static UserDaoImpl instance;

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
        user.setId(IdGenerator.createID());
        fileInitialization.getReadedUser().add(user);
        return user;
    }

    @Override
    public List<User> delete(int id) {
        fileInitialization.getReadedUser().removeIf(x -> x.getId() == id);
        return fileInitialization.getReadedUser();
    }

    @Override
    public List<User> find() {
        return fileInitialization.getReadedUser();
    }
}
