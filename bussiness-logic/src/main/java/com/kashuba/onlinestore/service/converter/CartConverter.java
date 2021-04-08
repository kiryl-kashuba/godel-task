package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.dto.CartDto;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    public Cart toModel(CartDto cartDto) {
        return new Cart();
    }

    public CartDto toDto(Cart cart) {
        return new CartDto();
    }
}
