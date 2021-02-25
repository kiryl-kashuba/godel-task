package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.exeption.ServiceProjectException;

import java.util.List;
import java.util.Map;

public interface UserService {

    User add(User user);

    User updateClient(User user);

    User removeClient(User user);

    User findClient(User user);

}
