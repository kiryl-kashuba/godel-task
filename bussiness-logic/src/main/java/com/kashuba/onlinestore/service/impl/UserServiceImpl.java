//package com.kashuba.onlinestore.service.impl;
//
//import com.kashuba.onlinestore.dao.impl.UserDaoImpl;
//import com.kashuba.onlinestore.entity.User;
//import com.kashuba.onlinestore.service.UserService;
//
//import java.util.List;
//
//public class UserServiceImpl implements UserService {
//
//    private static UserServiceImpl instance;
//
//    private UserServiceImpl() {
//    }
//
//    public static UserServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new UserServiceImpl();
//        }
//        return instance;
//    }
//
//
//    @Override
//    public User createUser(User user) {
//        return UserDaoImpl.getInstance().create(user);
//    }
//
//    @Override
//    public List<User> deleteUser(int id) {
//        return UserDaoImpl.getInstance().delete(id);
//    }
//
//    @Override
//    public List<User> findUsers() {
//        return UserDaoImpl.getInstance().findAll();
//    }
//}
