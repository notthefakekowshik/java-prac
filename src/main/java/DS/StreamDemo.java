package org.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        int a[] = new int[]{2,4,3,1,5};
        String names[]=new String[]{"kowshik" , "elon"};
        System.out.println(Arrays.stream(a).skip(2).findFirst().getAsInt());
        System.out.println(Arrays.stream(names).skip(1).findFirst().get());
        Arrays.stream(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .collect(Collectors.toList())
                .forEach(val -> System.out.println(val));
        List<Integer> ans = new ArrayList<>();
        ans =   Arrays.stream(a)
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                //.limit(1)
                .collect(Collectors.toList());
        ans.forEach(val -> System.out.print(val + " "));
        System.out.println();

        /* Printing in ascending order */
        System.out.println("Ascending order");
        Arrays.stream(a).sorted().forEach(value -> System.out.print(value+ " "));
        System.out.println();

        /* Printing in decending order */
        System.out.println("Descending order");
        Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).forEach(value -> System.out.print(value+ " "));
        System.out.println();

        /* Sum of n smallest numbers */
        int n = 3;
        int sum = Arrays.stream(a)
                .sorted()
                .limit(n)
                .sum();
        System.out.println("sum of " + n + " smallest numbers " + sum);



    }
}
