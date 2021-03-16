package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.OrderDao;
import com.kashuba.onlinestore.entity.Order;

import java.util.List;

public class OrderDaoImpl extends AbstractCRUDDao<Order> implements OrderDao {

    private static OrderDaoImpl instance;

    private OrderDaoImpl() {
    }

    public static OrderDaoImpl getInstance() {
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }

    @Override
    public Order create(Order order) {
        order.setId(IdGenerator.createID());

        return order;
    }

    @Override
    public List<Order> delete(int id) {
        return null;
    }

    @Override
    public List<Order> find() {
        return null;
    }
}
