package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}