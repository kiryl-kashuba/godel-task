package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.exeption.ServiceProjectException;

import java.util.List;
import java.util.Map;

public interface OrderService {

    boolean add(Map<String, String> orderParameters) throws ServiceProjectException;

    int calculateOrderAmount(/** */);

    List<Order> findOrdersByParameters(Map<String, String> orderParameters) throws ServiceProjectException;

    List<Order> findClientOrders(long clientId) throws ServiceProjectException;




}
