//package com.kashuba.onlinestore.service.impl;
//
//import com.kashuba.onlinestore.dao.impl.CartDaoImpl;
//import com.kashuba.onlinestore.entity.Cart;
//import com.kashuba.onlinestore.service.CartService;
//
//import java.util.List;
//
//public class CartServiceImpl implements CartService {
//
//    private CartDaoImpl cartDao = CartDaoImpl.getInstance();
//
//    private static CartServiceImpl instance;
//
//    private CartServiceImpl() {
//    }
//
//    public static CartServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new CartServiceImpl();
//        }
//        return instance;
//    }
//
//
//    @Override
//    public Cart createCart(Cart cart) {
//        return cartDao.create(cart);
//    }
//
//    @Override
//    public List<Cart> deleteCart(int id) {
//        return cartDao.delete(id);
//    }
//
//    @Override
//    public List<Cart> findCarts() {
//        return cartDao.findAll();
//    }
//
//    @Override
//    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
//        return cartDao.addInstanceToCart(idCart, idInstance, amount);
//    }
//
//
//}
