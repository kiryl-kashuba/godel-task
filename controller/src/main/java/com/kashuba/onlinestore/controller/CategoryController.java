package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.service.CategoryService;
import com.kashuba.onlinestore.service.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@Api(tags = "Controller of categories")
@Validated
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Create category")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        log.info("Creating category {}", categoryDto.getName());
        return categoryService.create(categoryDto);
    }

    @Operation(summary = "Delete category by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting category {}", id);
        categoryService.deleteById(id);
    }

    @Operation(summary = "Find all categories")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> findAllCategories() {
        log.info("Finding all categories");
        return categoryService.findAll();
    }

    @Operation(summary = "Find category by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CategoryDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding category {}", id);
        return categoryService.findById(id);
    }
}