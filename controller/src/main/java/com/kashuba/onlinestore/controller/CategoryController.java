package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.CategoryDto;
import com.kashuba.onlinestore.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Validated
@Slf4j
@Api(tags = "Controller of categories", description = "Operations with categories")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 409, message = "The request could not be completed due to a conflict with the current state of the target resource."),
        @ApiResponse(code = 500, message = "Server ERROR. Something go wrong")
})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "Create category")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        log.info("Creating category {}", categoryDto.getName());
        return categoryService.create(categoryDto);
    }

    @ApiOperation(value = "Delete category")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting category {}", id);
        categoryService.deleteById(id);
    }

    @ApiOperation(value = "Find all categories")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> findAllCategories() {
        log.info("Finding all categories");
        return categoryService.findAll();
    }

    @ApiOperation(value = "Find category by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CategoryDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding category {}", id);
        return categoryService.findById(id);
    }
}
