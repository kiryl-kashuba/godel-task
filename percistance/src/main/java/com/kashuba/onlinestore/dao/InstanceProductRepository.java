package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.InstanceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstanceProductRepository extends JpaRepository<InstanceProduct, Long> {
    List<InstanceProduct> findByCart_Id(Long id);
}