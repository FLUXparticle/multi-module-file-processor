package com.example.module1;

import java.util.Scanner;

public class Greeter {
    public static void print() {
        try (Scanner sc = new Scanner(Greeter.class.getResourceAsStream("/hello.txt"))) {
            String line = sc.nextLine();
            System.out.println("greeting = " + line);
        }
    }

}
