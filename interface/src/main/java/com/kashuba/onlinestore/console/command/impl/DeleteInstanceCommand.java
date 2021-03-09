package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.service.impl.InstanceProductServiceImpl;

import java.util.List;

public class DeleteInstanceCommand {

    private static DeleteInstanceCommand instance;

    private DeleteInstanceCommand() {
    }

    public static DeleteInstanceCommand getInstance() {
        if (instance == null) {
            instance = new DeleteInstanceCommand();
        }
        return instance;
    }

    InstanceProductServiceImpl instanceProductService = InstanceProductServiceImpl.getInstance();

    public List<InstanceProduct> deleteCLient(int idInstanceProduct) {
        return instanceProductService.deleteInstanceProduct(idInstanceProduct);
    }
}
