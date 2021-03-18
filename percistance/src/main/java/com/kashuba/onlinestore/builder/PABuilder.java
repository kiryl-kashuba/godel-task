package com.kashuba.onlinestore.builder;

import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.entity.User;

import java.util.Map;

public class PABuilder {
    public static ProductAttribute buildPA(Map<String, Object> userParameters) {
        User.Role role = (User.Role) userParameters.get("role");
        ProductAttribute productAttribute = new ProductAttribute();

        if (userParameters.containsKey("id")) {
            productAttribute.setId((long) userParameters.get("id"));
        }
//        productAttribute.setEmail((String) userParameters.get("email"));
//        productAttribute.setRole(role);
//        productAttribute.setFirstName((String) userParameters.get("first_name"));
//        productAttribute.setSecondName((String) userParameters.get("second_name"));
//        productAttribute.setPhoneNumber((long) userParameters.get("phone_number"));
//        productAttribute.setStatus((Client.Status) userParameters.get("status"));

        return productAttribute;
    }
}
