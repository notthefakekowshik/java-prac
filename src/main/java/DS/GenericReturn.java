package org.DSA;

public class GenericReturn {
    public static <T> T genericReturn(T t){
        return t;
    }

    public static void main(String[] args) {
        System.out.println(genericReturn(1));
        System.out.println(genericReturn("kowshik"));
    }
}
