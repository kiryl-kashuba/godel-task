package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.exeption.ServiceProjectException;

import java.util.Map;

public interface CategoryService {

    boolean add(Map<String, String> categoryParameters) throws ServiceProjectException;

}
