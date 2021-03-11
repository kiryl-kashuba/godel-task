package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.entity.BaseEntity;
import com.kashuba.onlinestore.entity.User;

import java.util.List;

public class UserDaoImpl extends FileInitializationHolder {

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
    public List<User> create(BaseEntity object) {
        object.setId(IdGenerator.createID());
        fileInitialization.getReadedUser().add((User) object);
        return fileInitialization.getReadedUser();
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
