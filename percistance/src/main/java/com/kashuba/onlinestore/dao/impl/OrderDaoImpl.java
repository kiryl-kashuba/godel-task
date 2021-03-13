package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.OrderDao;
import com.kashuba.onlinestore.entity.Order;

import java.util.List;

public class OrderDaoImpl extends AbstractCRUDDao implements OrderDao {

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
        fileInitialization.getReadedOrder().add(order);

        return order;
    }

    @Override
    public List<Order> delete(int id) {
        fileInitialization.getReadedOrder().removeIf(x -> x.getId() == id);
        return fileInitialization.getReadedOrder();
    }

    @Override
    public List<Order> find() {
        return fileInitialization.getReadedOrder();
    }
}
