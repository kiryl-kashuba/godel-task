package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}