package com.kashuba.onlinestore.fileservice;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.entity.*;

import java.io.IOException;
import java.util.List;

public class FileInitialization {
    public static String CLIENTR = "Client.txt";
    public static String CARTR = "Cart.txt";
    public static String CATEGORYR = "Category.txt";
    public static String PRODUCTR = "InstanceProduct.txt";
    public static String ORDERR = "Order.txt";
    public static String PAR = "ProductAttribute.txt";
    public static String USERR = "User.txt";
    public static String IDR = "Id.txt";

    List<Client> readedClients;
    List<Order> readedOrder;
    List<Cart> readedCart;
    List<InstanceProduct> readedProduct;
    List<Category> readedCategory;
    List<ProductAttribute> readedPA;
    List<User> readedUser;



    public List<Client> getReadedClients() {
        return readedClients;
    }

    public List<Order> getReadedOrder() {
        return readedOrder;
    }

    public List<Cart> getReadedCart() {
        return readedCart;
    }

    public List<InstanceProduct> getReadedProduct() {
        return readedProduct;
    }

    public List<Category> getReadedCategory() {
        return readedCategory;
    }

    public List<ProductAttribute> getReadedPA() {
        return readedPA;
    }

    public List<User> getReadedUser() {
        return readedUser;
    }

    {
        try {
            readedClients = (List<Client>) FileRepository.readObject(CLIENTR);
            readedOrder = (List<Order>) FileRepository.readObject(ORDERR);
            readedCart = (List<Cart>) FileRepository.readObject(CARTR);
            readedProduct = (List<InstanceProduct>) FileRepository.readObject(PRODUCTR);
            readedCategory = (List<Category>) FileRepository.readObject(CATEGORYR);
            readedPA = (List<ProductAttribute>) FileRepository.readObject(PAR);
            readedUser = (List<User>) FileRepository.readObject(USERR);
            IdGenerator.setIdCounter(FileRepository.readId(IDR));

            System.out.println("Initialization successful");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
