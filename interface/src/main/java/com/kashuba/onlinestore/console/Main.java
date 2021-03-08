package com.kashuba.onlinestore.console;

import com.budhash.cliche.Command;
import com.budhash.cliche.ShellFactory;
import com.kashuba.onlinestore.console.command.impl.*;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.*;
import com.kashuba.onlinestore.service.EnumService;

import java.io.IOException;
import java.util.*;

public class Main {

    {
        FileInitialization.getInstance();
    }

    @Command
    public String saveinfo() {
        return SaveInfoCommand.getInstance().saveInfo(FileInitialization.getInstance());
    }

    @Command
    public List<Client> createCLient(String email, String pass, String fname, String sname, long number, String role, String status) {
        Client client = new Client(email, pass, fname, sname, number);
        client.setRole(EnumService.findRole(role));
        client.setStatus(EnumService.findStatus(status));

        return CreateClientCommand.getInstance().createCLient(client);
    }

    @Command
    public List<Client> findCLients() {
        return FindClientCommand.getInstance().findCLients();
    }

    @Command
    public List<Client> deleteCLient(int idClient) {
        return DeleteClientCommand.getInstance().deleteCLient(idClient);
    }


    @Command
    public List<ProductAttribute> createProductAttribute(String name, boolean mandatory, String type) {
        ProductAttribute productAttribute = new ProductAttribute(name, mandatory, type);
        return CreateProductAttributeCommand.getInstance().createProductAttribute(productAttribute);
    }


    @Command
    public List<ProductAttribute> findProductAttributes() {
        return FindProductAttributeCommand.getInstance().findProductAttributes();
    }


    @Command
    public List<ProductAttribute> deleteProductAttribute(int idList) {
        return DeleteProductAttributeCommand.getInstance().DeleteProductAttribute(idList);
    }

    @Command
    public List<Category> createCAtegory(String name, Integer... idValue) {
        Category category = new Category(name);
        return CreateCategoryCommand.getInstance().createCLient(category, idValue);
    }

    @Command
    public List<Category> findCAtegory() {
        return FindCategoryCommand.getInstance().findCategories();
    }

    @Command
    public List<Category> deleteCAtegory(int idList) {
        return DeleteCategoryCommand.getInstance().deleteCategory(idList);
    }

    @Command
    public List<InstanceProduct> createINstance(String name, String articulation, int price, int idOfCategory) {
        InstanceProduct instanceProduct = new InstanceProduct(name, articulation, price);

        for (Category category : FindCategoryCommand.getInstance().findCategories()) {
            if (idOfCategory == category.getId()) {
                instanceProduct.setCategory(category);
            }
        }

        List<ProductAttributeValue> list = new ArrayList<>();

        for (Category category : FindCategoryCommand.getInstance().findCategories()) {
            if (idOfCategory == category.getId()) {
                int size = (category.getProductAttribute()).size();
                for (int i = 0; i < size; i++) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter value of " + ((category.getProductAttribute()).get(i)).getName());
                    String value = sc.nextLine();
                    list.add(createProductAttributeValue(value, (category.getProductAttribute()).get(i)));
                }
            }
        }
        instanceProduct.setProductAttributeValue(list);

        return CreateInstanceCommand.getInstance().createInstance(instanceProduct);
    }

    @Command
    public List<InstanceProduct> updateINstance(int idOfProduct, String name, String articulation, int price, int idOfCategory) {
        InstanceProduct instanceProduct = new InstanceProduct(name, articulation, price);

        for (Category category : FindCategoryCommand.getInstance().findCategories()) {
            if (idOfCategory == category.getId()) {
                instanceProduct.setCategory(category);
            }
        }

        List<ProductAttributeValue> list = new ArrayList<>();

        for (Category category : FindCategoryCommand.getInstance().findCategories()) {
            if (idOfCategory == category.getId()) {
                int size = (category.getProductAttribute()).size();
                for (int i = 0; i < size; i++) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter value of " + ((category.getProductAttribute()).get(i)).getName());
                    String value = sc.nextLine();
                    list.add(createProductAttributeValue(value, (category.getProductAttribute()).get(i)));
                }
            }
        }
        instanceProduct.setProductAttributeValue(list);

        return UpdateInstanceCommand.getInstance().updateInstance(instanceProduct, idOfProduct);
    }

    @Command
    public List<InstanceProduct> findINstance() {
        return FindInstanceCommand.getInstance().findInstances();
    }

    @Command
    public List<InstanceProduct> deleteINstance(int idInstance) {
        return DeleteInstanceCommand.getInstance().deleteCLient(idInstance);
    }

    @Command
    public ProductAttributeValue createProductAttributeValue(String value, ProductAttribute productAttribute) {
        ProductAttributeValue productAttributeValue = new ProductAttributeValue(value, productAttribute);
        return productAttributeValue;
    }

    @Command
    public List<Cart> createCArt(int idClient) {
        List<InstanceProduct> list = new ArrayList<>();
        Map<InstanceProduct, Integer> number = new HashMap<>();
        Cart cart = new Cart(list, number);
        for (Client client : FindClientCommand.getInstance().findCLients()) {
            if (idClient == client.getId()) {
                cart.setClient(client);
            }
        }
        return CreateCartCommand.getInstance().createInstance(cart);
    }

    @Command
    public List<Cart> findCART() {
        return FindCartCommand.getInstance().findCarts();
    }

    @Command
    public List<Cart> deleteCART(int idCart) {
        return DeleteCartCommand.getInstance().deleteCart(idCart);
    }

    @Command
    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        return AddInstanceToCartCommand.getInstance().addInstanceToCart(idCart, idInstance, amount);
    }


    @Command
    public List<Order> createORder(int idCart) {
        Order order = new Order();

        return CreateOrderCommand.getInstance().createOrder(order, idCart);
    }


    @Command
    public List<Order> findORder() {
        return FindOrderCommand.getInstance().findOrders();
    }

    @Command
    public List<Order> deleteORder(int idOrder) {
        return DeleteOrderCommand.getInstance().deleteOrder(idOrder);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter \"?l\" to see the available commands. Exit to terminate the program");
        ShellFactory.createConsoleShell("hello", "", new Main())
                .commandLoop(); // and three.
    }
}