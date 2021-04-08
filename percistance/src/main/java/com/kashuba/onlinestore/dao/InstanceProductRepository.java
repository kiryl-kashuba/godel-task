package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.InstanceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceProductRepository extends JpaRepository<InstanceProduct, Long> {
}