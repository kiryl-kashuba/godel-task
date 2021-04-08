package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
}