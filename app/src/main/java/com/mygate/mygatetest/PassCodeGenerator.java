package com.mygate.mygatetest;

import java.util.Random;

/**
 * Created by Sumit on 13/04/19.
 */


public class PassCodeGenerator {

    //private static final String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //private static final String Small_chars = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbers = "0123456789";
    //private static final String symbols = "!@#$%^&*_=+-/.?<>)";

    public static String generatePasscode() {

        String values = numbers;

        // Using random method
        Random random = new Random();

        char[] password = new char[6];

        for (int i = 0; i < 6; i++)
        {
            password[i] = values.charAt(random.nextInt(values.length()));

        }
        return String.valueOf(password);
    }
}