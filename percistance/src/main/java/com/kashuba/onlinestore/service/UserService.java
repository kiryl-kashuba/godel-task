package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.exeption.ServiceProjectException;

import java.util.Map;

public interface UserService {

    boolean add(Map<String, String> userParameters) throws ServiceProjectException;

}
