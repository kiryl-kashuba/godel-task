package com.kashuba.onlinestore.console;

import com.budhash.cliche.Command;
import com.budhash.cliche.ShellFactory;
import com.kashuba.onlinestore.console.command.impl.*;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.*;

import java.io.IOException;
import java.util.*;

public class Main {

    {
        FileInitialization.getInstance();
    }

    AddInstanceToCartCommand addInstanceToCartCommand = AddInstanceToCartCommand.getInstance();
    CreateClientCommand createClientCommand = CreateClientCommand.getInstance();
    CreateOrderCommand createOrderCommand = CreateOrderCommand.getInstance();
    CreateCartCommand createCartCommand = CreateCartCommand.getInstance();
    CreateCategoryCommand createCategoryCommand = CreateCategoryCommand.getInstance();
    CreateInstanceCommand createInstanceCommand = CreateInstanceCommand.getInstance();
    CreateProductAttributeCommand createProductAttributeCommand = CreateProductAttributeCommand.getInstance();
    CreateProductAttributeValueCommand createProductAttributeValueCommand = CreateProductAttributeValueCommand.getInstance();
    DeleteCartCommand deleteCartCommand = DeleteCartCommand.getInstance();
    DeleteCategoryCommand deleteCategoryCommand = DeleteCategoryCommand.getInstance();
    DeleteClientCommand deleteClientCommand = DeleteClientCommand.getInstance();
    DeleteInstanceCommand deleteInstanceCommand = DeleteInstanceCommand.getInstance();
    DeleteOrderCommand deleteOrderCommand = DeleteOrderCommand.getInstance();
    DeleteProductAttributeCommand deleteProductAttributeCommand = DeleteProductAttributeCommand.getInstance();
    DeleteProductAttributeValueCommand deleteProductAttributeValueCommand = DeleteProductAttributeValueCommand.getInstance();
    FindCartCommand findCartCommand = FindCartCommand.getInstance();
    FindCategoryCommand findCategoryCommand = FindCategoryCommand.getInstance();
    FindClientCommand findClientCommand = FindClientCommand.getInstance();
    FindInstanceCommand findInstanceCommand = FindInstanceCommand.getInstance();
    FindOrderCommand findOrderCommand = FindOrderCommand.getInstance();
    FindProductAttributeCommand findProductAttributeCommand = FindProductAttributeCommand.getInstance();
    FindProductAttributeValueCommand findProductAttributeValueCommand = FindProductAttributeValueCommand.getInstance();
    SaveInfoCommand saveInfoCommand = SaveInfoCommand.getInstance();
    UpdateInstanceCommand updateInstanceCommand = UpdateInstanceCommand.getInstance();


    @Command
    public void saveinfo() {
        saveInfoCommand.saveInfo(FileInitialization.getInstance());
    }

    @Command
    public List<Client> createCLient(String email, String pass, String fname, String sname,
                                     long number, String role, String status) {
        Client client = new Client(email, pass, fname, sname, number);
        client.setRole(User.Role.findRole(role));
        client.setStatus(Client.Status.findStatus(status));

        return createClientCommand.createCLient(client);
    }

    @Command
    public List<Client> findCLients() {
        return findClientCommand.findCLients();
    }

    @Command
    public List<Client> deleteCLient(int idClient) {
        return deleteClientCommand.deleteCLient(idClient);
    }


    @Command
    public List<ProductAttribute> createProductAttribute(String name, boolean mandatory, String type) {
        ProductAttribute productAttribute = new ProductAttribute(name, mandatory, type);
        return createProductAttributeCommand.createProductAttribute(productAttribute);
    }


    @Command
    public List<ProductAttribute> findProductAttributes() {
        return findProductAttributeCommand.findProductAttributes();
    }


    @Command
    public List<ProductAttribute> deleteProductAttribute(int idList) {
        return deleteProductAttributeCommand.DeleteProductAttribute(idList);
    }

    @Command
    public List<Category> createCAtegory(String name, Integer... idValue) {
        Category category = new Category(name);
        return createCategoryCommand.createCLient(category, idValue);
    }

    @Command
    public List<Category> findCAtegory() {
        return findCategoryCommand.findCategories();
    }

    @Command
    public List<Category> deleteCAtegory(int idList) {
        return deleteCategoryCommand.deleteCategory(idList);
    }

    @Command
    public List<InstanceProduct> createINstance(String name, String articulation, int price, int idOfCategory) {
        InstanceProduct instanceProduct = new InstanceProduct(name, articulation, price);

        for (Category category : findCategoryCommand.findCategories()) {
            if (idOfCategory == category.getId()) {
                instanceProduct.setCategory(category);
            }
        }

        List<ProductAttributeValue> list = new ArrayList<>();

        for (Category category : findCategoryCommand.findCategories()) {
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

        return createInstanceCommand.createInstance(instanceProduct);
    }

    @Command
    public List<InstanceProduct> updateINstance(int idOfProduct, String name, String articulation,
                                                int price, int idOfCategory) {
        InstanceProduct instanceProduct = new InstanceProduct(name, articulation, price);

        for (Category category : findCategoryCommand.findCategories()) {
            if (idOfCategory == category.getId()) {
                instanceProduct.setCategory(category);
            }
        }

        List<ProductAttributeValue> list = new ArrayList<>();

        for (Category category : findCategoryCommand.findCategories()) {
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

        return updateInstanceCommand.updateInstance(instanceProduct, idOfProduct);
    }

    @Command
    public List<InstanceProduct> findINstance() {
        return findInstanceCommand.findInstances();
    }

    @Command
    public List<InstanceProduct> deleteINstance(int idInstance) {
        return deleteInstanceCommand.deleteCLient(idInstance);
    }

    @Command
    public ProductAttributeValue createProductAttributeValue(String value, ProductAttribute productAttribute) {
        ProductAttributeValue productAttributeValue = new ProductAttributeValue(value, productAttribute);
        return createProductAttributeValueCommand.createProductAttribute(productAttributeValue);
    }

    @Command
    public List<ProductAttributeValue> findProductAttributeValue() {
        return findProductAttributeValueCommand.findProductAttributeValue();
    }

    @Command
    public List<ProductAttributeValue> deleteProductAttributeValue(int idInstance) {
        return deleteProductAttributeValueCommand.deleteProductAttributeValue(idInstance);
    }


    @Command
    public List<Cart> createCArt(int idClient) {
        List<InstanceProduct> list = new ArrayList<>();
        Map<InstanceProduct, Integer> number = new HashMap<>();
        Cart cart = new Cart(list, number);
        for (Client client : findClientCommand.findCLients()) {
            if (idClient == client.getId()) {
                cart.setClient(client);
            }
        }
        return createCartCommand.createInstance(cart);
    }

    @Command
    public List<Cart> findCART() {
        return findCartCommand.findCarts();
    }

    @Command
    public List<Cart> deleteCART(int idCart) {
        return deleteCartCommand.deleteCart(idCart);
    }

    @Command
    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        return addInstanceToCartCommand.addInstanceToCart(idCart, idInstance, amount);
    }

    @Command
    public List<Order> createORder(int idCart) {
        Order order = new Order();

        return createOrderCommand.createOrder(order, idCart);
    }

    @Command
    public List<Order> findORder() {
        return findOrderCommand.findOrders();
    }

    @Command
    public List<Order> deleteORder(int idOrder) {
        return deleteOrderCommand.deleteOrder(idOrder);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter \"?l\" to see the available commands. Exit to terminate the program");
        ShellFactory.createConsoleShell("hello", "", new Main())
                .commandLoop(); // and three.
    }
}