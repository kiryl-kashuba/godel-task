package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.service.CategoryService;
import com.kashuba.onlinestore.service.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    void delete(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Category> findAllCategories() {
        return categoryService.findCategories();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Category> findById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }
}
