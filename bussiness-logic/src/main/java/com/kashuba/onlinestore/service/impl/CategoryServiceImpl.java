package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.CategoryRepository;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.CategoryService;
import com.kashuba.onlinestore.service.converter.CategoryConverter;
import com.kashuba.onlinestore.service.dto.CategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }


}
