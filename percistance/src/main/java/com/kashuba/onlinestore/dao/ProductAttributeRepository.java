package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
    List<ProductAttribute> findByCategory_Id(Long id); //findByCategory_Id
}