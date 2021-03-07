package com.kashuba.onlinestore.console;

import com.budhash.cliche.Command;
import com.budhash.cliche.ShellFactory;
import com.kashuba.onlinestore.dao.fileservice.FileRepository;
import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.console.command.impl.CreateClientCommand;
import com.kashuba.onlinestore.console.command.impl.DeleteClientCommand;
import com.kashuba.onlinestore.console.command.impl.FindClientCommand;
import com.kashuba.onlinestore.entity.*;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.User.Role;
import com.kashuba.onlinestore.service.EnumService;

import java.io.IOException;
import java.util.*;

import static com.kashuba.onlinestore.dao.fileservice.FileInitialization.*;

public class Main {
//    public static String CLIENTR = "Client.txt";
//    public static String CARTR = "Cart.txt";
//    public static String CATEGORYR = "Category.txt";
//    public static String PRODUCTR = "InstanceProduct.txt";
//    public static String ORDERR = "Order.txt";
//    public static String PAR = "ProductAttribute.txt";
//    public static String USERR = "User.txt";
//    public static String IDR = "Id.txt";
//
//    List<Client> readedClients;
//    List<Order> readedOrder;
//    List<Cart> readedCart;
//    List<InstanceProduct> readedProduct;
//    List<Category> readedCategory;
//    List<ProductAttribute> readedPA;
//    List<User> readedUser;
//
//    {
//        try {
//            readedClients = (List<Client>) FileRepository.readObject(CLIENTR);
//            readedOrder = (List<Order>) FileRepository.readObject(ORDERR);
//            readedCart = (List<Cart>) FileRepository.readObject(CARTR);
//            readedProduct = (List<InstanceProduct>) FileRepository.readObject(PRODUCTR);
//            readedCategory = (List<Category>) FileRepository.readObject(CATEGORYR);
//            readedPA = (List<ProductAttribute>) FileRepository.readObject(PAR);
//            readedUser = (List<User>) FileRepository.readObject(USERR);
//            IdGenerator.setIdCounter(FileRepository.readId(IDR));
//
//            System.out.println("Initialization successful");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    FileInitialization fileInitialization = new FileInitialization();


    @Command
    public List<Client> createCLient(String email, String pass, String fname, String sname, long number, String role, String status) {
        Client client = new Client(email, pass, fname, sname, number);
        client.setRole(EnumService.findRole(role));
        client.setStatus(EnumService.findStatus(status));

        CreateClientCommand createClientCommand = new CreateClientCommand();
        return createClientCommand.createCLient(email, pass, fname, sname, number, fileInitialization.getReadedClients());
    }

    @Command
    public List<Client> findCLients() {
        FindClientCommand findClientCommand = new FindClientCommand();
        return findClientCommand.findCLients(fileInitialization.getReadedClients());
    }

    @Command
        public List<Client> deleteCLient(int idClient) {
        DeleteClientCommand deleteClientCommand = new DeleteClientCommand();
        return deleteClientCommand.deleteCLient(idClient, fileInitialization.getReadedClients());
        }
//
//    @Command
//    public List<ProductAttribute> createProductAttribute(String name, boolean mandatory, String type) {
//        long id = IdGenerator.createID();
//        ProductAttribute productAttribute = new ProductAttribute(name, mandatory, id, type);
//        readedPA.add(productAttribute);
//        return readedPA;
//    }
//
//
//    @Command
//    public List<ProductAttribute> findProductAttributes() {
//        return readedPA;
//    }
//
//
//    @Command
//    public List<ProductAttribute> deleteProductAttribute(int idList) {
//        readedPA.removeIf(x -> x.getId() == idList);
//        return readedPA;
//    }
//
//    @Command
//    public List<Category> createCAtegory(String name, Integer... idValue) {
//        long id = IdGenerator.createID();
//        List<ProductAttribute> list = new ArrayList<>();
//        for (int i = 0; i < idValue.length; i++) {
//            for (ProductAttribute productAttribute : readedPA) {
//                if (idValue[i] == productAttribute.getId()) {
//                    list.add(productAttribute);
//                }
//            }
//        }
//        Category category = new Category(name, list, id);
//        readedCategory.add(category);
//        return readedCategory;
//
//    }
//
//    @Command
//    public List<Category> findCAtegory() {
//        return readedCategory;
//    }
//
//    @Command
//    public List<Category> deleteCAtegory(int idList) {
//        readedPA.removeIf(x -> x.getId() == idList);
//        return readedCategory;
//    }
//
//    @Command
//    public List<InstanceProduct> createINstance(String name, String articulation, int price, int idOfCategory) {
//        long id = IdGenerator.createID();
//        InstanceProduct instanceProduct = new InstanceProduct(id, name, articulation, price);
//        for (Category category : readedCategory) {
//            if (idOfCategory == category.getId()) {
//                instanceProduct.setCategory(category);
//            }
//        }
//
//        List<ProductAttributeValue> list = new ArrayList<>();
//
//        for (Category category : readedCategory) {
//            if (idOfCategory == category.getId()) {
//                int size = (category.getProductAttribute()).size();
//                for (int i = 0; i < size; i++) {
//                    Scanner sc = new Scanner(System.in);
//                    System.out.println("Enter value of " + ((category.getProductAttribute()).get(i)).getName());
//                    String value = sc.nextLine();
//                    list.add(createProductAttributeValue(value, (category.getProductAttribute()).get(i)));
//                }
//            }
//        }
//        instanceProduct.setProductAttributeValue(list);
//        readedProduct.add(instanceProduct);
//        return readedProduct;
//    }
//
//    @Command
//    public void updateINstance(int idOfProduct, String name, String articulation, int price, int idOfCategory) {
//        List<ProductAttributeValue> list = new ArrayList<>();
//        for (Category category : readedCategory) {
//            if (idOfCategory == category.getId()) {
//                int size = (category.getProductAttribute()).size();
//                for (int i = 0; i < size; i++) {
//                    Scanner sc = new Scanner(System.in);
//                    System.out.println("Enter value of " + ((category.getProductAttribute()).get(i)).getName());
//                    String value = sc.nextLine();
//                    list.add(createProductAttributeValue(value, (category.getProductAttribute()).get(i)));
//                }
//            }
//        }
//        for (InstanceProduct instanceProduct : readedProduct) {
//            if (idOfProduct == instanceProduct.getId()) {
//                instanceProduct.setName(name);
//                instanceProduct.setArticulation(articulation);
//                instanceProduct.setPrice(price);
//                instanceProduct.setProductAttributeValue(list);
//            }
//        }
//    }
//
//    @Command
//    public List<InstanceProduct> findINstance() {
//        return readedProduct;
//    }
//
//    @Command
//    public List<InstanceProduct> deleteINstance(int idList) {
//        readedProduct.removeIf(x -> x.getId() == idList);
//        return readedProduct;
//    }
//
//    @Command
//    public ProductAttributeValue createProductAttributeValue(String value, ProductAttribute productAttribute) {
//        long id = IdGenerator.createID();
//        ProductAttributeValue productAttributeValue = new ProductAttributeValue(value, productAttribute, id);
//        return productAttributeValue;
//    }
//
//    @Command
//    public List<Cart> createCArt(int idClient) {
//        long id = IdGenerator.createID();
//        List<InstanceProduct> list = new ArrayList<>();
//        Map<InstanceProduct, Integer> number = new HashMap<>();
//        Cart cart = new Cart(id, list, number);
//        for (Client client : readedClients) {
//            if (idClient == client.getId()) {
//                cart.setClient(client);
//            }
//        }
//        readedCart.add(cart);
//        return readedCart;
//
//    }
//
//    @Command
//    public List<Cart> findCART() {
//        return readedCart;
//    }
//
//    @Command
//    public List<Cart> deleteCART(int idList) {
//        readedCart.removeIf(x -> x.getId() == idList);
//        return readedCart;
//    }
//
//    @Command
//    public void addInstanceToCart(int idCart, int idInstance, Integer amount) {
//        for (Cart cart : readedCart) {
//            if (idCart == cart.getId()) {
//                for (InstanceProduct instanceProduct : readedProduct) {
//                    if (idInstance == instanceProduct.getId()) {
//                        cart.getNumber().put(instanceProduct,amount);
//                        cart.addInstanceProduct(instanceProduct);
//                    }
//                }
//            }
//        }
//    }
//
//    @Command
//    public List<Order> createORder(int idCart) {
//        long id = IdGenerator.createID();
//        Order order = new Order(id, LocalDate.now());
//        for (Cart cart : readedCart) {
//            if (idCart == cart.getId()) {
//                order.setCart(cart);
//            }
//        }
//        int amount = 0;
//
//        for (Cart cart : readedCart) {
//            if (idCart == cart.getId()) {
//                order.setCart(cart);
//                for (Map.Entry<InstanceProduct, Integer> entry : cart.getNumber().entrySet()) {
//                    InstanceProduct product = entry.getKey();
//                    Integer number = entry.getValue();
//                    amount += product.getPrice() * number;
//                }
//            }
//        }
//        order.setAmount(amount);
//        readedOrder.add(order);
//        return readedOrder;
//    }
//
//
//    @Command
//    public List<Order> findORder() {
//        return readedOrder;
//    }
//
//    @Command
//    public List<Order> deleteORder(int idList) {
//        readedPA.removeIf(x -> x.getId() == idList);
//        return readedOrder;
//    }

    @Command
    public void saveinfo() throws IOException {
        List<Object> lists = new ArrayList();
        lists.add(fileInitialization.getReadedClients());
        lists.add(fileInitialization.getReadedCart());
        lists.add(fileInitialization.getReadedCategory());
        lists.add(fileInitialization.getReadedOrder());
        lists.add(fileInitialization.getReadedProduct());
        lists.add(fileInitialization.getReadedPA());
        lists.add(fileInitialization.getReadedUser());

        List<Object> listsOfFile = new ArrayList();
        listsOfFile.add(CLIENTR);
        listsOfFile.add(CARTR);
        listsOfFile.add(CATEGORYR);
        listsOfFile.add(ORDERR);
        listsOfFile.add(PRODUCTR);
        listsOfFile.add(PAR);
        listsOfFile.add(USERR);

        for (int x = 0; x < lists.size(); x++) {
            FileRepository.writeObject((String) listsOfFile.get(x), lists.get(x));
        }

        FileRepository.writeId(IDR, IdGenerator.getIdCounter());

        System.out.println("Data saved");
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Enter \"?l\" to see the available commands. Exit to terminate the program");
        ShellFactory.createConsoleShell("hello", "", new Main())
                .commandLoop(); // and three.
    }
}