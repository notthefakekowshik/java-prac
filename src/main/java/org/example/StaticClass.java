package org.example;

public class StaticClass {

    static class innerClass {
        void innerClassAction() {
            System.out.println("in the inner static class");
        }
    }
    public static void main(String[] args) {
        System.out.println("doesnt allow to put static on the outer class");
    }
}
