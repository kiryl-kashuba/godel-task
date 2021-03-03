package com.kashuba.onlinestore.console;


import com.budhash.cliche.Command;
import com.budhash.cliche.ShellFactory;
import com.kashuba.onlinestore.FileRepository;
import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.entity.*;


import java.io.IOException;
import java.util.*;


public class Main {
    public static String CLIENTR = "Client.txt";
    public static String CARTR = "Cart.txt";
    public static String CATEGORYR = "Category.txt";
    public static String PRODUCTR = "InstanceProduct.txt";
    public static String ORDERR = "Order.txt";
    public static String PAR = "ProductAttribute.txt";
    public static String PAVR = "ProductAttributeValue.txt";
    public static String USERR = "User.txt";
    public static String IDR = "Id.txt";


    List<Client> readedClients;
    List<Order> readedOrder;
    List<Cart> readedCart;
    List<InstanceProduct> readedProduct;
    List<Category> readedCategory;
    List<ProductAttribute> readedPA;
    List<ProductAttributeValue> readedPAV;
    List<User> readedUser;




     {
        try {
            readedClients = (List<Client>) FileRepository.readObject(CLIENTR);
            readedOrder = (List<Order>) FileRepository.readObject(ORDERR);
            readedCart = (List<Cart>) FileRepository.readObject(CARTR);
            readedProduct = (List<InstanceProduct>) FileRepository.readObject(PRODUCTR);
            readedCategory = (List<Category>) FileRepository.readObject(CATEGORYR);
            System.out.println(readedPA);
            readedPA = (List<ProductAttribute>) FileRepository.readObject(PAR);
            System.out.println(readedPA);
            readedPAV = (List<ProductAttributeValue>) FileRepository.readObject(PAVR);
            readedUser = (List<User>) FileRepository.readObject(USERR);
            IdGenerator.setIdCounter(FileRepository.readId(IDR));

            System.out.println("Initialization successful");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            new ArrayList<>();
        }
    }

    @Command
    public List<Client> addClient(String email, String pass, String fname, String sname, long number)  {
        User.Role role = User.Role.CLIENT;
        Client.Status status = Client.Status.ACTIVE;
        long id = IdGenerator.createID();
        Client client = new Client( email, role, pass, id, fname, sname, number, status);
        readedClients.add(client);
        return readedClients;

    }

    @Command
    public List<Client> findClients(){
        return readedClients;
    }


    @Command
    public List<Client> removeClient(int idList) {
        readedClients.removeIf(x -> x.getId() == idList);
        return readedClients;
    }

    @Command
    public List<ProductAttribute> addProductAttribute(String name, boolean mandatory)  {
        long id = IdGenerator.createID();
        ProductAttribute productAttribute = new ProductAttribute( name, mandatory, id);
        readedPA.add(productAttribute);
        return readedPA;

    }

    @Command
    public List<ProductAttribute> findProductAttributes(){
        return readedPA;
    }


    @Command
    public List<ProductAttribute> removeProductAttribute(int idList) {
        readedPA.removeIf(x -> x.getId() == idList);
        return readedPA;
    }

    @Command
    public void saveInfo() throws IOException {
        List<Object> lists = new ArrayList();
        lists.add(readedClients);
        lists.add(readedCart);
        lists.add(readedCategory);
        lists.add(readedOrder);
        lists.add(readedProduct);
        lists.add(readedPA);
        lists.add(readedPAV);
        lists.add(readedUser);

        List<Object> listsOfFile = new ArrayList();
        listsOfFile.add(CLIENTR);
        listsOfFile.add(CARTR);
        listsOfFile.add(CATEGORYR);
        listsOfFile.add(ORDERR);
        listsOfFile.add(PRODUCTR);
        listsOfFile.add(PAR);
        listsOfFile.add(PAVR);
        listsOfFile.add(USERR);

        for (int x= 0; x<lists.size(); x++)
        {
            FileRepository.writeObject((String) listsOfFile.get(x), lists.get(x));
        }

        FileRepository.writeId(IDR ,IdGenerator.getIdCounter());


        System.out.println("Data saved");
    }

    // Client
//    @Command
//    public void addClient(String email, String pass, String fname, String sname, long number) throws IOException {
//        User.Role role = User.Role.CLIENT;
//        Client.Status status = Client.Status.ACTIVE;
//        Client client = new Client(fname, sname, number, status, email, role, pass);
//        List<Client> clients = new ArrayList<>(Arrays.asList(client));
//        FileRepository.writeObject(CLIENTR, clients);
//    }


//    @Command
//    public List<Client> findClients() throws IOException, ClassNotFoundException {
//        List<Client> readedClients = (List<Client>) FileRepository.readObject(CLIENTR);
//        return readedClients;
//    }

    // Cart
//    @Command
//    public void addCart(int number, Client client, InstanceProduct instanceProduct) throws IOException {
//        Cart cart = new Cart(number, client, instanceProduct);
//        List<Cart> carts = new ArrayList<>(Arrays.asList(cart));
//        FileRepository.writeObject(CLIENTR, carts);
//    }
//
//    @Command
//    public List<Cart> findCart() throws IOException, ClassNotFoundException {
//        List<Cart> readedClients = (List<Cart>) FileRepository.readObject(CLIENTR);
//        return readedClients;
//    }
//
//    @Command
//    public void show(){
//        System.out.println(readedClients);
//    }
    // Category
//    @Command
//    public void addCategory(String email, String pass, String fname, String sname, long number) throws IOException {
//
//        Category category = new Category(fname, sname, number, status, email, role, pass);
//        List<Category> clients = new ArrayList<>(Arrays.asList(category));
//        FileRepository.writeObject(CLIENTR, clients);
//    }
//
//    @Command
//    public List<Category> findCategory() throws IOException, ClassNotFoundException {
//        List<Category> readedClients = (List<Category>) FileRepository.readObject(CLIENTR);
//        return readedClients;
//    }
//
//    // InstanceProduct
//    @Command
//    public void addInstanceProduct(String email, String pass, String fname, String sname, long number) throws IOException {
//
//        InstanceProduct instanceProduct = new InstanceProduct(fname, sname, number, status, email, role, pass);
//        List<InstanceProduct> clients = new ArrayList<>(Arrays.asList(instanceProduct));
//        FileRepository.writeObject(CLIENTR, clients);
//    }
//
//    @Command
//    public List<InstanceProduct> findInstanceProduct() throws IOException, ClassNotFoundException {
//        List<InstanceProduct> readedClients = (List<InstanceProduct>) FileRepository.readObject(CLIENTR);
//        return readedClients;
//    }
//
//    // Order
//    @Command
//    public void addOrder(String email, String pass, String fname, String sname, long number) throws IOException {
//
//        Order order = new Order(fname, sname, number, status, email, role, pass);
//        List<Order> clients = new ArrayList<>(Arrays.asList(order));
//        FileRepository.writeObject(CLIENTR, clients);
//    }
//
//    @Command
//    public List<Order> findOrder() throws IOException, ClassNotFoundException {
//        List<Order> readedClients = (List<Order>) FileRepository.readObject(CLIENTR);
//        return readedClients;
//    }
//
//    // ProductAttribute
//    @Command
//    public void addProductAttribute(String email, String pass, String fname, String sname, long number) throws IOException {
//
//        ProductAttribute productAttribute = new ProductAttribute(fname, sname, number, status, email, role, pass);
//        List<ProductAttribute> clients = new ArrayList<>(Arrays.asList(productAttribute));
//        FileRepository.writeObject(CLIENTR, clients);
//    }
//
//    @Command
//    public List<ProductAttribute> findProductAttribute() throws IOException, ClassNotFoundException {
//        List<ProductAttribute> readedClients = (List<ProductAttribute>) FileRepository.readObject(CLIENTR);
//        return readedClients;
//    }
//
//// ProductAttributeValue
//    @Command
//    public void addProductAttributeValue(String email, String pass, String fname, String sname, long number) throws IOException {
//
//        ProductAttributeValue productAttributeValue = new ProductAttributeValue(fname, sname, number, status, email, role, pass);
//        List<ProductAttributeValue> clients = new ArrayList<>(Arrays.asList(productAttributeValue));
//        FileRepository.writeObject(CLIENTR, clients);
//    }
//
//    @Command
//    public List<ProductAttributeValue> findProductAttributeValue() throws IOException, ClassNotFoundException {
//        List<ProductAttributeValue> readedClients = (List<ProductAttributeValue>) FileRepository.readObject(CLIENTR);
//        return readedClients;
//    }
//// User
//    @Command
//    public void addUser(String email, String pass, String fname, String sname, long number) throws IOException {
//
//        User user = new User(fname, sname, number, status, email, role, pass);
//        List<User> clients = new ArrayList<>(Arrays.asList(user));
//        FileRepository.writeObject(CLIENTR, clients);
//    }
//
//    @Command
//    public List<User> findUser() throws IOException, ClassNotFoundException {
//        List<User> readedClients = (List<User>) FileRepository.readObject(CLIENTR);
//        return readedClients;
//    }


    public static void main(String[] args) throws IOException {
        System.out.println("Enter \"?l\" to see the available commands. Exit to terminate the program");
        ShellFactory.createConsoleShell("hello", "", new Main())
                .commandLoop(); // and three.
    }
}