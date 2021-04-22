package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.CartRepository;
import com.kashuba.onlinestore.dao.ClientRepository;
import com.kashuba.onlinestore.dao.InstanceProductRepository;
import com.kashuba.onlinestore.dao.OrderRepository;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.OrderService;
import com.kashuba.onlinestore.service.converter.OrderConverter;
import com.kashuba.onlinestore.service.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    OrderConverter orderConverter = new OrderConverter();
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InstanceProductRepository instanceProductRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Order createOrder(OrderDto orderDto) {
        Client client = clientRepository.findByEmail(orderDto.getEmailOfClient());
        Order order = orderConverter.toModel(orderDto);
        int amount = 0;
        List<InstanceProduct> instanceProductList = instanceProductRepository.findByCart_Id(client.getId());
        for (InstanceProduct instanceProduct : instanceProductList) {
            amount += instanceProduct.getPrice() * instanceProduct.getNumber();
//            instanceProductRepository.deleteById(instanceProduct.getId());
        }
        order.setDateOrder(LocalDate.now());
        order.setAmount(amount);
        order.setClient(client);
        order.setCart(cartRepository.findById(client.getId()).get());


        return orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

}
