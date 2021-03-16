package com.kashuba.onlinestore.console;

import com.budhash.cliche.Command;
import com.budhash.cliche.ShellFactory;
import com.kashuba.onlinestore.console.command.impl.*;
import com.kashuba.onlinestore.entity.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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
    UpdateInstanceCommand updateInstanceCommand = UpdateInstanceCommand.getInstance();

    @Command(name = "Create Client - String email, String pass, String fname, String sname,long number, " +
            "String role, String status", abbrev = "ccl")
    public Client createClient(String email, String pass, String fname, String sname,
                               long number, String role, String status) {
        Client client = new Client(email, pass, fname, sname, number);
        client.setRole(User.Role.findRole(role));
        client.setStatus(Client.Status.findStatus(status));

        return createClientCommand.createCLient(client);
    }

    @Command(name = "Find Clients", abbrev = "fcl")
    public List<Client> findClients() {
        return findClientCommand.findCLients();
    }

    @Command(name = "Delete Client - int idClient", abbrev = "dcl")
    public List<Client> deleteClient(int idClient) {
        return deleteClientCommand.deleteCLient(idClient);
    }


    @Command(name = "Create Product Attribute - String name, boolean mandatory, String type", abbrev = "cpa")
    public ProductAttribute createProductAttribute(String name, boolean mandatory, String type) {
        ProductAttribute productAttribute = new ProductAttribute(name, mandatory, type);
        return createProductAttributeCommand.createProductAttribute(productAttribute);
    }


    @Command(name = "Find Product Attributes", abbrev = "fpa")
    public List<ProductAttribute> findProductAttributes() {
        return findProductAttributeCommand.findProductAttributes();
    }


    @Command(name = "Delete Product Attribute - int idList", abbrev = "dpa")
    public List<ProductAttribute> deleteProductAttribute(int idList) {
        return deleteProductAttributeCommand.DeleteProductAttribute(idList);
    }

    @Command(name = "Create Category - String name, Integer... idValue", abbrev = "cca")
    public Category createCategory(String name, Integer... idValue) {
        Category category = new Category(name);
        return createCategoryCommand.createCLient(category, idValue);
    }

    @Command(name = "Find Category", abbrev = "fca")
    public List<Category> findCategory() {
        return findCategoryCommand.findCategories();
    }

    @Command(name = "Delete Category - int idList", abbrev = "dca")
    public List<Category> deleteCategory(int idList) {
        return deleteCategoryCommand.deleteCategory(idList);
    }

    @Command(name = "Create Instance - String name, String articulation, int price, int idOfCategory", abbrev = "ci")
    public InstanceProduct createInstance(String name, String articulation, int price, int idOfCategory) {
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

    @Command(name = "Update Instance - int idOfProduct, String name, String articulation, int price, int idOfCategory", abbrev = "ui")
    public List<InstanceProduct> updateInstance(int idOfProduct, String name, String articulation,
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

    @Command(name = "FindInstance", abbrev = "fi")
    public List<InstanceProduct> findInstance() {
        return findInstanceCommand.findInstances();
    }

    @Command(name = "Delete Instance - int idInstance", abbrev = "di")
    public List<InstanceProduct> deleteInstance(int idInstance) {
        return deleteInstanceCommand.deleteCLient(idInstance);
    }

    @Command(name = "Create Product Attribute Value - String value, ProductAttribute productAttribute", abbrev = "cpav")
    public ProductAttributeValue createProductAttributeValue(String value, ProductAttribute productAttribute) {
        ProductAttributeValue productAttributeValue = new ProductAttributeValue(value, productAttribute);
        return createProductAttributeValueCommand.createProductAttribute(productAttributeValue);
    }

    @Command(name = "Find Product Attribute Value", abbrev = "fpav")
    public List<ProductAttributeValue> findProductAttributeValue() {
        return findProductAttributeValueCommand.findProductAttributeValue();
    }

    @Command(name = "Delete Product Attribute Value - int idInstance", abbrev = "dpav")
    public List<ProductAttributeValue> deleteProductAttributeValue(int idInstance) {
        return deleteProductAttributeValueCommand.deleteProductAttributeValue(idInstance);
    }


    @Command(name = "Create Cart - int idClient", abbrev = "cc")
    public Cart createCArt(int idClient) {
        List<InstanceProduct> list = new ArrayList<>();
        List<NumberContainer> number = new ArrayList<>();
        Cart cart = new Cart(list, number);
        for (Client client : findClientCommand.findCLients()) {
            if (idClient == client.getId()) {
                cart.setClient(client);
            }
        }
        return createCartCommand.createInstance(cart);
    }

    @Command(name = "Find Cart", abbrev = "fc")
    public List<Cart> findCart() {
        return findCartCommand.findCarts();
    }

    @Command(name = "Delete Cart - int idCart", abbrev = "dc")
    public List<Cart> deleteCart(int idCart) {
        return deleteCartCommand.deleteCart(idCart);
    }

    @Command(name = "Add Instance To Cart - int idCart, int idInstance, Integer amount", abbrev = "ac")
    public Cart addInstanceToCart(int idCart, int idInstance, Integer amount) {
        return addInstanceToCartCommand.addInstanceToCart(idCart, idInstance, amount);
    }

    @Command(name = "Create Order - int idCart", abbrev = "co")
    public Order createOrder(int idCart) {
        Order order = new Order();
        order.setDateOrder(LocalDate.now());

        return createOrderCommand.createOrder(order, idCart);
    }

    @Command(name = "Find Order", abbrev = "fo")
    public List<Order> findOrder() {
        return findOrderCommand.findOrders();
    }

    @Command(name = "Delete Order - int idOrder", abbrev = "do")
    public List<Order> deleteOrder(int idOrder) {
        return deleteOrderCommand.deleteOrder(idOrder);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter \"?l\" to see the available commands. Exit to terminate the program");
        ShellFactory.createConsoleShell("hello", "", new Main())
                .commandLoop(); // and three.
    }
}