package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    boolean add(Map<String, String> orderParameters);

    int calculateOrderAmount(/** */);

    List<Order> findOrdersByParameters(Map<String, String> orderParameters) ;

    List<Order> findClientOrders(long clientId);




}
