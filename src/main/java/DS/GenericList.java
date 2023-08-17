package org.DSA;

import java.util.ArrayList;
import java.util.List;

public class GenericList {

    public static <T> void genericListPrinter(List<T> list){
        for(T currElement : list){
            System.out.println(currElement);
        }
    }

    public static void main(String[] args) {
        List<Integer> numsList = new ArrayList<>();
        numsList.add(1);
        numsList.add(2);
        numsList.add(3);

        List<String> stringList = new ArrayList<>();
        stringList.add("elon musk");
        stringList.add("kowshik");

        genericListPrinter(numsList);
        genericListPrinter(stringList);
    }
}
