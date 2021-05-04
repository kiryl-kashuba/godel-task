package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.converter.OrderConverter;
import com.kashuba.onlinestore.dao.CartRepository;
import com.kashuba.onlinestore.dao.ClientRepository;
import com.kashuba.onlinestore.dao.InstanceProductRepository;
import com.kashuba.onlinestore.dao.OrderRepository;
import com.kashuba.onlinestore.dto.OrderDto;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderConverter orderConverter;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InstanceProductRepository instanceProductRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public OrderDto create(OrderDto orderDto) {
        Client client = clientRepository.findByEmail(orderDto.getEmailOfClient());
        Order order = orderConverter.toModel();
        Long amount = 0L;
        List<InstanceProduct> instanceProductList = instanceProductRepository.findByCart_Id(client.getId());
        for (InstanceProduct instanceProduct : instanceProductList) {
            amount += instanceProduct.getPrice() * instanceProduct.getNumber();
//            instanceProductRepository.deleteById(instanceProduct.getId());
        }
        order.setDateOrder(LocalDate.now());
        order.setAmount(amount);
        order.setClient(client);
        order.setCart(cartRepository.findById(client.getId()).get());

        return orderConverter.toDto(orderRepository.saveAndFlush(order));
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDto> findAll() {
        return orderConverter.toListDto(orderRepository.findAll());
    }

    public Optional<OrderDto> findById(Long id) {
        return orderConverter.toOptionalDto(orderRepository.findById(id));
    }

}
