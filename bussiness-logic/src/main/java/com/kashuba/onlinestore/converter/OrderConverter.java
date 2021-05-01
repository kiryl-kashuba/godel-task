package com.kashuba.onlinestore.converter;

import com.kashuba.onlinestore.dto.OrderDto;
import com.kashuba.onlinestore.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderConverter {

    public Order toModel(OrderDto orderDto) {
        return new Order();
    }

    public OrderDto toDto(Order order) {
        return new OrderDto(order.getAmount(), order.getDateOrder());
    }

    public Optional<OrderDto> toOptionalDto(Optional<Order> order) {
        OrderDto orderDto = new OrderDto(order.get().getAmount(), order.get().getDateOrder());
        return Optional.of(orderDto);
    }

    public List<OrderDto> toListDto(List<Order> orderList) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orderList) {
            orderDtos.add(new OrderDto(order.getAmount(), order.getDateOrder()));
        }
        return orderDtos;
    }
}
