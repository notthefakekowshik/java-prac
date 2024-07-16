package DS.JAVA21.Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SequencedCollection;

public class SeqQequeVsQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);


        System.out.println("Starting demo of sequenced queue");
        SequencedCollection<Integer> sq = new LinkedList<>();
        sq.add(1);
        sq.addFirst(2);
        sq.add(3);
        System.out.println(sq);


        System.out.println("Starting demo of reversed sequenced queue");
        SequencedCollection<Integer> reversedSq = sq.reversed();
        System.out.println(reversedSq);


    }
}
