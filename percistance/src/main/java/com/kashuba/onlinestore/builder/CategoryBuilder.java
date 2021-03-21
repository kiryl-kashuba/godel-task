package com.kashuba.onlinestore.builder;

import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.ProductAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryBuilder {
    public static Category buildCategory(Map<String, Object> categoryParameters) {
        Category buildingCategory = new Category();

        if (categoryParameters.containsKey("id")) {
            buildingCategory.setId((long) categoryParameters.get("id"));
        }
        buildingCategory.setName((String) categoryParameters.get("name"));
        buildingCategory.setProductAttribute(buildPA(categoryParameters));

        return buildingCategory;
    }

    public static boolean booleanCheck(int value) {
        boolean check = false;
        if (value >= 1) {
            check = true;
        }
        return check;
    }

    public static List<ProductAttribute> buildPA(Map<String, Object> categoryParameters) {
        ProductAttribute buildingPA = new ProductAttribute();
        List<ProductAttribute> listOfPA = new ArrayList<>();

        buildingPA.setName((String) categoryParameters.get("product_attributes.name"));
        buildingPA.setMandatory(booleanCheck((int) categoryParameters.get("product_attributes.mandatory")));
        buildingPA.setType((String) categoryParameters.get("product_attributes.type"));

        listOfPA.add(buildingPA);

        return listOfPA;
    }

}
