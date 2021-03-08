package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.UserDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

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
    public List<User> createUser(User user) {
        user.setId(IdGenerator.createID());
        FileInitialization.getInstance().getReadedUser().add(user);
        return FileInitialization.getInstance().getReadedUser();
    }

    @Override
    public List<User> deleteUser(int idUser) {
        FileInitialization.getInstance().getReadedUser().removeIf(x -> x.getId() == idUser);
        return FileInitialization.getInstance().getReadedUser();
    }

    @Override
    public List<User> findUsers() {
        return FileInitialization.getInstance().getReadedUser();
    }
}
