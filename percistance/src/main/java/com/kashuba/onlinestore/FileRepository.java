package com.kashuba.onlinestore;

import java.io.*;
import java.util.ArrayList;

public class FileRepository {
    private FileRepository(){}

    public static void writeObject(String fileName, Object object) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
    }

    public static  Object readObject(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            } catch (EOFException e) {
            System.out.println(fileName + "is empty" + e);
                return new ArrayList<>();
            }

        return objectInputStream.readObject();
    }
}
