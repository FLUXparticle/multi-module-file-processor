package com.example.module2;

import com.example.module1.Greeter;

import java.net.*;

public class Main {
    public static void main(String[] args) {
        URLClassLoader classLoader = (URLClassLoader) Main.class.getClassLoader();

        for (URL url : classLoader.getURLs()) {
            System.out.println("url = " + url);
        }

        Greeter.print();
    }
}
