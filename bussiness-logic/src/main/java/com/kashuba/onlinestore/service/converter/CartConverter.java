package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.service.dto.CartDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CartConverter {

    public Cart toModel() {
        return new Cart();
    }

    public CartDto toDto(Cart cart) {
        return new CartDto(cart.getClient(), cart.getInstanceProduct());
    }

    public Optional<CartDto> toOptionalDto(Optional<Cart> cart) {
        CartDto cartDto = new CartDto(cart.get().getClient(), cart.get().getInstanceProduct());
        return Optional.of(cartDto);
    }

    public List<CartDto> toListDto(List<Cart> cartList) {
        List<CartDto> cartDtoList = new ArrayList<>();
        for (Cart cart : cartList) {
            cartDtoList.add(new CartDto(cart.getClient(), cart.getInstanceProduct()));
        }
        return cartDtoList;
    }
}
