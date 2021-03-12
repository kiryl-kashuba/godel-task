package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.impl.InstanceProductServiceImpl;

public class CreateInstanceCommand {

    private static CreateInstanceCommand instance;
    private InstanceProductServiceImpl instanceProductService = InstanceProductServiceImpl.getInstance();

    private CreateInstanceCommand() {
    }

    public static CreateInstanceCommand getInstance() {
        if (instance == null) {
            instance = new CreateInstanceCommand();
        }
        return instance;
    }


    public InstanceProduct createInstance(InstanceProduct instanceProduct) {
        return instanceProductService.createInstanceProduct(instanceProduct);
    }
}
