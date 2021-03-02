package com.kashuba.onlinestore;

import com.kashuba.onlinestore.entity.Client;

import java.io.*;
import java.util.List;

public class FileRepository {
    private FileRepository(){} //Gl

    public static void writeObject(String fileName, Object object) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
    }

    public static Object readObject(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            } catch (EOFException e) {
                return new List<>();
            }

        return objectInputStream.readObject();
    }
}
