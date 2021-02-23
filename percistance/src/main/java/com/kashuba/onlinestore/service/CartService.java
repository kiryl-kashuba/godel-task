package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.exeption.ServiceProjectException;

import java.util.Map;

public interface CartService {

    boolean add(Map<String, String> cartParameters) throws ServiceProjectException;

}
