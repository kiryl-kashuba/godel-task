package com.kashuba.onlinestore;

public class IdGenerator {

    private static long idCounter = 0;

    public static synchronized long createID()
    {
        return idCounter++;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        IdGenerator.idCounter = idCounter;
    }
}
