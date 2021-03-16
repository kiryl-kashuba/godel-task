package com.kashuba.onlinestore.builder;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;

import java.util.Map;

public class PABuilder {
    public static Client buildClient(Map<String, Object> userParameters) {
        User.Role role = (User.Role) userParameters.get("role");
        Client buildingClient = new Client();

        if (userParameters.containsKey("id")) {
            buildingClient.setId((long) userParameters.get("id"));
        }
        buildingClient.setEmail((String) userParameters.get("email"));
        buildingClient.setRole(role);
        buildingClient.setFirstName((String) userParameters.get("first_name"));
        buildingClient.setSecondName((String) userParameters.get("second_name"));
        buildingClient.setPhoneNumber((long) userParameters.get("phone_number"));
        buildingClient.setStatus((Client.Status) userParameters.get("status"));

        return buildingClient;
    }
}
