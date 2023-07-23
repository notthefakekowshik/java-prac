package org.DSA.Matrixes;

import java.util.Arrays;

public class ReverseInPlace {

    public static void revInPlace(int a[])
    {

    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        revInPlace(a);
        Arrays.stream(a).forEach(val-> System.out.println(val));
    }
}
