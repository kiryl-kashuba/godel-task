package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.impl.UserDaoImpl;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }


    @Override
    public List<User> createUser(User user) {
        return UserDaoImpl.getInstance().createUser(user);
    }

    @Override
    public List<User> deleteUser(int idUser) {
        return UserDaoImpl.getInstance().deleteUser(idUser);
    }

    @Override
    public List<User> findUsers() {
        return UserDaoImpl.getInstance().findUsers();
    }
}
