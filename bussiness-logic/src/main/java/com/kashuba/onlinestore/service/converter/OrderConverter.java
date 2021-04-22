package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Order;
import com.kashuba.onlinestore.service.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public Order toModel(OrderDto orderDto) {
        return new Order();
    }

    public OrderDto toDto(Order order) {
        return new OrderDto();
    }
}
