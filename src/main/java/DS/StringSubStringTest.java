package org.DSA;

public class StringSubStringTest {

    public static void main(String[] args) {
        String filterName = "BA%";
        if(filterName.charAt(0) == '%'){
            filterName = filterName.substring(1,filterName.length());
        }
        if(filterName.charAt(filterName.length()-1) == '%'){
            filterName = filterName.substring(0,filterName.length()-1);
        }
        System.out.println(filterName);
    }
}
