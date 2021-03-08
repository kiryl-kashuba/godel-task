package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.User;

import java.util.List;

public interface UserService {

    List<User> createUser(User user);

    List<User> deleteUser(int idUser);

    List<User> findUsers();

}
