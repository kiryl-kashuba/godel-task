package com.kashuba.onlinestore.dao.fileservice;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInitialization {

    private static FileInitialization instance;

    private FileInitialization() {
    }

    public static FileInitialization getInstance() {
        if (instance == null) {
            instance = new FileInitialization();
        }
        return instance;
    }

    public static String CLIENTR = "Client.txt";
    public static String CARTR = "Cart.txt";
    public static String CATEGORYR = "Category.txt";
    public static String PRODUCTR = "InstanceProduct.txt";
    public static String ORDERR = "Order.txt";
    public static String PAR = "ProductAttribute.txt";
    public static String USERR = "User.txt";
    public static String IDR = "Id.txt";
    public static String PAVR = "ProductAttributeValue.txt";

    List<Client> readedClients = new ArrayList<>();
    List<Order> readedOrder = new ArrayList<>();
    List<Cart> readedCart = new ArrayList<>();
    List<InstanceProduct> readedProduct = new ArrayList<>();
    List<Category> readedCategory = new ArrayList<>();
    List<ProductAttribute> readedPA = new ArrayList<>();
    List<ProductAttributeValue> readedPAV = new ArrayList<>();
    private List<User> readedUser = new ArrayList<>();

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

    public List<ProductAttributeValue> getReadedPAV() {
        return readedPAV;
    }

    {
        try {
            System.out.println(readedClients);
            System.out.println(readedOrder);
            System.out.println(readedCart);
            System.out.println(readedProduct);
            System.out.println(readedCategory);
            System.out.println(readedPA);
            System.out.println(readedUser);
            readedClients = (List<Client>) FileRepository.readObject(CLIENTR);
            readedOrder = (List<Order>) FileRepository.readObject(ORDERR);
            readedCart = (List<Cart>) FileRepository.readObject(CARTR);
            readedProduct = (List<InstanceProduct>) FileRepository.readObject(PRODUCTR);
            readedCategory = (List<Category>) FileRepository.readObject(CATEGORYR);
            readedPA = (List<ProductAttribute>) FileRepository.readObject(PAR);
            readedUser = (List<User>) FileRepository.readObject(USERR);
            readedPAV = (List<ProductAttributeValue>) FileRepository.readObject(PAVR);
            System.out.println(readedClients);
            System.out.println(readedOrder);
            System.out.println(readedCart);
            System.out.println(readedProduct);
            System.out.println(readedCategory);
            System.out.println(readedPA);
            System.out.println(readedUser);
            System.out.println(readedPAV);
            IdGenerator.setIdCounter(FileRepository.readId(IDR));

            System.out.println("Initialization successful");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
