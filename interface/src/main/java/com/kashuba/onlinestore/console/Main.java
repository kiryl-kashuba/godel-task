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
            System.out.println(readedCategory);
            readedPA = (List<ProductAttribute>) FileRepository.readObject(PAR);
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
    public List<Client> createClient(String email, String pass, String fname, String sname, long number)  {
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
    public List<Client> deleteClient(int idList) {
        readedClients.removeIf(x -> x.getId() == idList);
        return readedClients;
    }

    @Command
    public List<ProductAttribute> createProductAttribute(String name, boolean mandatory)  {
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
    public List<ProductAttribute> deleteProductAttribute(int idList) {
        readedPA.removeIf(x -> x.getId() == idList);
        return readedPA;
    }


    @Command
    public List<Category> createCategory(String name, Integer ...idValue)  {
        long id = IdGenerator.createID();
        List<ProductAttribute> list = new ArrayList<>();
        for (int i=0; i< idValue.length;i++){
            for (ProductAttribute productAttribute : readedPA){
                if (idValue[i] == productAttribute.getId()){
                    list.add(productAttribute);
                }
            }
        }
        Category category = new Category(name, list, id);
        readedCategory.add(category);
        return readedCategory;

    }



    @Command
    public List<Category> findСategories(){
        System.out.println(readedCategory);
        return readedCategory;
    }


    @Command
    public List<Category> deleteCategory(int idList) {
        readedPA.removeIf(x -> x.getId() == idList);
        return readedCategory;
    }

//    @Command
//    public List<ProductAttribute> addProductAttribute(String name, boolean mandatory)  {
//        long id = IdGenerator.createID();
//        ProductAttribute productAttribute = new ProductAttribute( name, mandatory, id);
//        readedPA.add(productAttribute);
//        return readedPA;
//
//    }
//
//    @Command
//    public List<ProductAttribute> findProductAttributes(){
//        return readedPA;
//    }
//
//
//    @Command
//    public List<ProductAttribute> removeProductAttribute(int idList) {
//        readedPA.removeIf(x -> x.getId() == idList);
//        return readedPA;
//    }

    @Command
    public void saveinfo() throws IOException {
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



    public static void main(String[] args) throws IOException {
        System.out.println("Enter \"?l\" to see the available commands. Exit to terminate the program");
        ShellFactory.createConsoleShell("hello", "", new Main())
                .commandLoop(); // and three.
    }
}