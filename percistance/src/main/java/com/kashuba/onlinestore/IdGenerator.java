package com.kashuba.onlinestore;

public class IdGenerator {
    private static long idCounter = 0;

    public static synchronized String createID()
    {
        return String.valueOf(idCounter++);
    }
}
