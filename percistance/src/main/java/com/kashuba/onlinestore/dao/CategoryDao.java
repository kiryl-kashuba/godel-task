package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> create(Category category, Integer... idValue);

    List<Category> delete(int id);

    List<Category> find();
}
