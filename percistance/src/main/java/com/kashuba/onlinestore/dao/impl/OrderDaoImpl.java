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

    private OrderDaoImpl() {
    }

    public static OrderDaoImpl getInstance() {
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Order> createOrder(Order order, int idCart) {
        order.setId(IdGenerator.createID());
        order.setDateOrder(LocalDate.now());

        for (Cart cart : FileInitialization.getInstance().getReadedCart()) {
            if (idCart == cart.getId()) {
                order.setCart(cart);
            }
        }

        int amount = 0;

        for (Cart cart : FileInitialization.getInstance().getReadedCart()) {
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

        FileInitialization.getInstance().getReadedOrder().add(order);
        return FileInitialization.getInstance().getReadedOrder();
    }

    @Override
    public List<Order> deleteOrder(int idOrder) {
        FileInitialization.getInstance().getReadedOrder().removeIf(x -> x.getId() == idOrder);
        return FileInitialization.getInstance().getReadedOrder();
    }

    @Override
    public List<Order> findOrders() {
        return FileInitialization.getInstance().getReadedOrder();
    }
}
