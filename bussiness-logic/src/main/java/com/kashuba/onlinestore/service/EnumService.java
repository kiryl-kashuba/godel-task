package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;

public class EnumService {

    public static User.Role findRole(String role) {
        User.Role user = null;
        for (User.Role env : User.Role.values()) {
            if (role.equals(env.getvalueOfRole())) {
                user = env;
            }
        }
        return user;
    }

    public static Client.Status findStatus(String status) {
        Client.Status user = null;
        for (Client.Status env : Client.Status.values()) {
            if (status.equals(env.getValue())) {
                user = env;
            }
        }
        return user;
    }
}
