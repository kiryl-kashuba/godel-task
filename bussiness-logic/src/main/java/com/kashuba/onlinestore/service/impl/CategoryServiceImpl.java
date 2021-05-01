package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.converter.CategoryConverter;
import com.kashuba.onlinestore.dao.CategoryRepository;
import com.kashuba.onlinestore.dto.CategoryDto;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.CategoryService;
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
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = categoryConverter.toModel(categoryDto);
        return categoryConverter.toDto(categoryRepository.saveAndFlush(category));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryConverter.toListDto(categoryRepository.findAll());
    }

    public Optional<CategoryDto> findById(Long id) {
        return categoryConverter.toOptionalDto(categoryRepository.findById(id));
    }


}
