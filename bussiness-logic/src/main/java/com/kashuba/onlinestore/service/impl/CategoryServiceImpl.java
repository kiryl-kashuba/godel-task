package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.CategoryRepository;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.CategoryService;
import com.kashuba.onlinestore.service.converter.CategoryConverter;
import com.kashuba.onlinestore.service.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryConverter categoryConverter = new CategoryConverter();
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = categoryConverter.toModel(categoryDto);
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }
}
