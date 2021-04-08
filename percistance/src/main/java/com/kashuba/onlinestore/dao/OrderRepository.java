package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}