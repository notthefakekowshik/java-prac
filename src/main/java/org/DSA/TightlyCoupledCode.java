package org.DSA;

public class TightlyCoupledCode {
    static class student{
        person p ;
        student(){
            p = new person("kowshik");
            System.out.println(p.name);
        }
    }
    static class person{
        String name;
        person(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {
        student s = new student();
    }
}
