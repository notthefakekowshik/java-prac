package DS.JAVA21.Collections;

import java.util.ArrayList;
import java.util.List;

public class SequencedCollectionDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addFirst(1);
        list.addFirst(3);
        list.addLast(2);
        System.out.println(list);

        /*
        output : 3 1 2
         */
    }
}
