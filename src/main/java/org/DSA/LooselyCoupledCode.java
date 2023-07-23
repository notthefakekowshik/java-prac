package org.DSA;

public class LooselyCoupledCode {
    static class student{
        person p;
        student(person p){
            this.p = p;
        }
        void displayName(){
            System.out.println(this.p.name);
        }
    }
    static class person{
        String name;
        person(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {
        person p = new person("kavya");
        student s = new student(p);
        s.displayName();
    }
}
