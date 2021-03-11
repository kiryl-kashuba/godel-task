package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.OrderDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    private static OrderDaoImpl instance;
    public FileInitialization fileInitialization = FileInitialization.getInstance();

    private OrderDaoImpl() {
    }

    public static OrderDaoImpl getInstance() {
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Order> create(Order order, int idCart) {
        order.setId(IdGenerator.createID());
        order.setDateOrder(LocalDate.now());

        for (Cart cart : fileInitialization.getReadedCart()) {
            if (idCart == cart.getId()) {
                order.setCart(cart);
            }
        }

        int amount = 0;

        for (Cart cart : fileInitialization.getReadedCart()) {
            if (idCart == cart.getId()) {
                order.setCart(cart);
                for (Map.Entry<InstanceProduct, Integer> entry : cart.getNumber().entrySet()) {
                    InstanceProduct product = entry.getKey();
                    Integer number = entry.getValue();
                    amount += product.getPrice() * number;
                }
            }
        }
        order.setAmount(amount);

        fileInitialization.getReadedOrder().add(order);
        return fileInitialization.getReadedOrder();
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
