package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.impl.InstanceProductServiceImpl;

import java.util.List;

public class UpdateInstanceCommand {

    private static UpdateInstanceCommand instance;
    private InstanceProductServiceImpl instanceProductService = InstanceProductServiceImpl.getInstance();

    private UpdateInstanceCommand() {
    }

    public static UpdateInstanceCommand getInstance() {
        if (instance == null) {
            instance = new UpdateInstanceCommand();
        }
        return instance;
    }


    public List<InstanceProduct> updateInstance(InstanceProduct instanceProduct, int idOfProduct) {
        return instanceProductService.updateInstanceProduct(instanceProduct, idOfProduct);
    }
}
