//package com.kashuba.onlinestore.service.impl;
//
//import com.kashuba.onlinestore.dao.impl.ProductAttributeValueDaoImpl;
//import com.kashuba.onlinestore.entity.ProductAttributeValue;
//import com.kashuba.onlinestore.service.ProductAttributeValueService;
//
//import java.util.List;
//
//public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {
//
//    private ProductAttributeValueDaoImpl productAttributeValueDao = ProductAttributeValueDaoImpl.getInstance();
//
//    private static ProductAttributeValueServiceImpl instance;
//
//    private ProductAttributeValueServiceImpl() {
//    }
//
//    public static ProductAttributeValueServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new ProductAttributeValueServiceImpl();
//        }
//        return instance;
//    }
//
//    @Override
//    public ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue) {
//        return productAttributeValueDao.create(productAttributeValue);
//    }
//
//    @Override
//    public List<ProductAttributeValue> deleteProductAttributeValue(int id) {
//        return productAttributeValueDao.delete(id);
//    }
//
//    @Override
//    public List<ProductAttributeValue> findProductAttributeValues() {
//        return productAttributeValueDao.findAll();
//    }
//}
