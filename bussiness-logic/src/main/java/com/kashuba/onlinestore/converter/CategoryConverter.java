package com.kashuba.onlinestore.converter;

import com.kashuba.onlinestore.dto.CategoryDto;
import com.kashuba.onlinestore.entity.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryConverter {

    public Category toModel(CategoryDto categoryDto) {
        return new Category(categoryDto.getName());
    }

    public CategoryDto toDto(Category category) {
        return new CategoryDto(category.getName(), category.getProductAttribute());
    }

    public Optional<CategoryDto> toOptionalDto(Optional<Category> category) {
        CategoryDto categoryDto = new CategoryDto(category.get().getName(), category.get().getProductAttribute());
        return Optional.of(categoryDto);
    }

    public List<CategoryDto> toListDto(List<Category> categoryList) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDtoList.add(new CategoryDto(category.getName(), category.getProductAttribute()));
        }
        return categoryDtoList;
    }
}
