package com.kashuba.onlinestore.builder;

import com.kashuba.onlinestore.entity.Category;

import java.util.Map;

public class CategoryBuilder {
    public static Category buildCategory(Map<String, Object> categoryParameters) {
        Category buildingCategory = new Category();

        if (categoryParameters.containsKey("id")) {
            buildingCategory.setId((long) categoryParameters.get("id"));
        }
        buildingCategory.setName((String) categoryParameters.get("name"));

        return buildingCategory;
    }

}
