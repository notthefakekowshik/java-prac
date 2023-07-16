package org.example;

import java.util.Arrays;

public class GenericExtends {
    public static <T extends Number> void genericPrinter(T var){
        System.out.println(var);
        System.out.println(var.getClass().getName());
        String temp[] = var.getClass().getName().split(".");
        System.out.println(Arrays.stream(temp).toList());
    }
    public static void main(String[] args) {
        //GenericExtends.genericPrinter("kowshik");, this throws error
        GenericExtends.genericPrinter(1);
    }
}
