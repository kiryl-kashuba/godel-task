package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.CategoryService;
import com.kashuba.onlinestore.service.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Category createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Category category) {
        categoryService.deleteCategory(category);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Category> findAllCategories() {
        return categoryService.findCategories();
    }
}
