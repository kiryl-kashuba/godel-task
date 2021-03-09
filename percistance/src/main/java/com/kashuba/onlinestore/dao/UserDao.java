package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.User;

import java.util.List;

public interface UserDao {

    List<User> create(User user);

    List<User> delete(int id);

    List<User> find();
}
