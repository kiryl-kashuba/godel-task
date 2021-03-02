package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.InstanceProductDao;
import com.kashuba.onlinestore.dao.impl.InstanceProductDaoImpl;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.exeption.ServiceProjectException;
import com.kashuba.onlinestore.service.InstanceProductService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InstanceProductServiceImpl implements InstanceProductService {
    InstanceProductDao instanceProductDao = new InstanceProductDaoImpl();

    @Override
    public InstanceProduct add(InstanceProduct instanceProduct) {
        instanceProductDao.add(instanceProduct);
            return null;
        }

    @Override
    public InstanceProduct updateInstanceProduct(InstanceProduct InstanceProduct) {
        return null;
    }

    @Override
    public InstanceProduct removeInstanceProduct(InstanceProduct InstanceProduct) {
        return null;
    }

    @Override
    public InstanceProduct findInstanceProducts(InstanceProduct InstanceProduct) {
        return null;
    }

    @Override
    public InstanceProduct updateInstanceProductStatus(InstanceProduct updatingInstanceProduct, String statusData) {
        return null;
    }

    @Override
    public List<InstanceProduct> findInstanceProductsById(String InstanceProductIdData) {
        return null;
    }

    @Override
    public Optional<InstanceProduct> findInstanceProductById(long instanceProductId) throws ServiceProjectException {
        return Optional.empty();
    }

    @Override
    public List<InstanceProduct> findInstanceProductsByParameters(Map<String, String> instanceProductParametersData) throws ServiceProjectException {
        return null;
    }
}
