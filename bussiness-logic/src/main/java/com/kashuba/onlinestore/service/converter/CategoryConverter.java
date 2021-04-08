package com.kashuba.onlinestore.service.converter;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public Category toModel(CategoryDto categoryDto) {
        return new Category();
    }

    public CategoryDto toDto(Category category) {
        return new CategoryDto();
    }
}
