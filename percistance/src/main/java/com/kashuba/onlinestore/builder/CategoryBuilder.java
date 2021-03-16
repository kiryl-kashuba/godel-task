package com.kashuba.onlinestore.builder;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;

import java.util.Map;

public class CategoryBuilder {
    public static Client buildCategory(Map<String, Object> categoryParameters) {
        Category buildingCategory = new Category();

        if (categoryParameters.containsKey("id")) {
            buildingCategory.setId((long) userParameters.get("id"));
        }
        buildingCategory.setEmail((String) userParameters.get("email"));
        buildingCategory.setFirstName((String) userParameters.get("first_name"));
        buildingCategory.setSecondName((String) userParameters.get("second_name"));
        buildingCategory.setPhoneNumber((long) userParameters.get("phone_number"));
        buildingCategory.setRole((User.Role) userParameters.get("role"));
        buildingCategory.setStatus((Client.Status) userParameters.get("status"));

        return buildingCategory;
    }
}
