package com.kashuba.onlinestore.console;


import com.budhash.cliche.Command;
import com.budhash.cliche.ShellFactory;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;


import java.io.IOException;

public class Main {

    @Command
    public String hello() {
        return "Hello, World!";
    }

    @Command
    public int add(int a, int b) {
        return a + b;
    }

    @Command
    public Client addClient(String email, Long id, String pass,
                            String fname, String sname, long number) {
        Client buildingClient = new Client();
        buildingClient.setEmail(email);
        buildingClient.setId(id);
        buildingClient.setPassword(pass);
        buildingClient.setFirstName(fname);
        buildingClient.setSecondName(sname);
        buildingClient.setPhoneNumber(number);
        System.out.println(buildingClient);
        return buildingClient;
    }

        public static void main (String[]args) throws IOException {
            System.out.println("Enter \"?List\" to see the available commands. Exit to terminate the program");
            ShellFactory.createConsoleShell("hello", "", new Main())
                    .commandLoop(); // and three.
        }
    }