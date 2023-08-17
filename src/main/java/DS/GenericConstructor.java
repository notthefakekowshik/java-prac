package org.DSA;

public class GenericConstructor {
    private int x;
    <T extends Number> GenericConstructor(T t){
        x = t.intValue();
        System.out.println("Generic constructor " + x);
    }

    GenericConstructor(String name){
        System.out.println("in string constructor");
    }

    public static void main(String[] args) {
        new GenericConstructor(1);
        new GenericConstructor("kowshik");
    }
}
