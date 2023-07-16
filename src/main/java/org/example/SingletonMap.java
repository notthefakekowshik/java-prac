package org.example;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SingletonMap {

    public static void main(String[] args) {

        Map<String,Integer> sm = Collections.singletonMap("kowshik" , 1);

        sm = new HashMap<String, Integer>();
        System.out.println(sm);
    }
}
