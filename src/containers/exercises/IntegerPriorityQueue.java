package containers.exercises;

import java.util.PriorityQueue;
import java.util.Random;

public class IntegerPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random rand = new Random(47);

        for (int i = 0; i < 100; i++) {
            int v = rand.nextInt(500);
            System.out.print(v + " ");
            pq.add(v);
        }
        System.out.println();
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }
}
