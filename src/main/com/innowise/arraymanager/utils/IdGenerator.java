package com.innowise.arraymanager.utils;

public class IdGenerator {

    private static Integer entityCounter = 0;


    public static int incrementAndGet() {
        return entityCounter++;
    }
}
