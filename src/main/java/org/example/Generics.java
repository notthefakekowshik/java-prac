package org.example;

import java.util.Arrays;

public class Generics {

    public static <T> void genericPrinter(T var){
        System.out.println(var);
        System.out.println(var.getClass().getName());
        String temp[] = var.getClass().getName().split(".");
        System.out.println(Arrays.stream(temp).toList());
    }
    public static void main(String[] args) {
        Generics.genericPrinter("kowshik");
        Generics.genericPrinter(1);
    }
}
