package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.impl.InstanceProductServiceImpl;

import java.util.List;

public class FindInstanceCommand {

    private static FindInstanceCommand instance;

    private FindInstanceCommand() {
    }

    public static FindInstanceCommand getInstance() {
        if (instance == null) {
            instance = new FindInstanceCommand();
        }
        return instance;
    }

    InstanceProductServiceImpl instanceProductService = InstanceProductServiceImpl.getInstance();

    public List<InstanceProduct> findInstances() {
        return instanceProductService.findInstanceProducts();
    }

}
