//package com.kashuba.onlinestore.service.impl;
//
//import com.kashuba.onlinestore.dao.impl.ProductAttributeDaoImpl;
//import com.kashuba.onlinestore.entity.ProductAttribute;
//import com.kashuba.onlinestore.service.ProductAttributeService;
//
//import java.util.List;
//
//public class ProductAttributeServiceImpl implements ProductAttributeService {
//
//    private ProductAttributeDaoImpl productAttributeDao = ProductAttributeDaoImpl.getInstance();
//
//    private static ProductAttributeServiceImpl instance;
//
//    private ProductAttributeServiceImpl() {
//    }
//
//    public static ProductAttributeServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new ProductAttributeServiceImpl();
//        }
//        return instance;
//    }
//
//    @Override
//    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
//        return productAttributeDao.create(productAttribute);
//    }
//
//    @Override
//    public List<ProductAttribute> deleteProductAttribute(int idAttribute) {
//        return productAttributeDao.delete(idAttribute);
//    }
//
//    @Override
//    public List<ProductAttribute> findProductAttributes() {
//        List<ProductAttribute> paList = null;
//        try {
//            paList = productAttributeDao.findAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return paList;
//    }
//}
