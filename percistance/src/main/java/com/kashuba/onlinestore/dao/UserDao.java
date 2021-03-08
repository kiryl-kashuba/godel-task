package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.User;

import java.util.List;

public interface UserDao {

    List<User> createUser(User user);

    List<User> deleteUser(int idUser);

    List<User> findUsers();
}
