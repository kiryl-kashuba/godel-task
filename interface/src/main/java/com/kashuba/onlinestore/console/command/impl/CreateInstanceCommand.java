package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.impl.InstanceProductServiceImpl;

import java.util.List;

public class CreateInstanceCommand {

    private static CreateInstanceCommand instance;

    private CreateInstanceCommand() {
    }

    public static CreateInstanceCommand getInstance() {
        if (instance == null) {
            instance = new CreateInstanceCommand();
        }
        return instance;
    }

    public List<InstanceProduct> createInstance(InstanceProduct instanceProduct) {
        return InstanceProductServiceImpl.getInstance().createInstanceProduct(instanceProduct);
    }
}
