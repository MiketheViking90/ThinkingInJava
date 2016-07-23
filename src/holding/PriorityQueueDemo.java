package holding;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random rand = new Random(47);

        for (int i = 0; i < 10; i++) {
            pq.offer(rand.nextInt(i + 10));
        }
        printQ(pq);

        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        pq = new PriorityQueue<>(ints);
        printQ(pq);
    }

    private static void printQ(PriorityQueue<Integer> pq) {
        PriorityQueue<Integer> pqCopy = new PriorityQueue<>(pq);
        while (!pqCopy.isEmpty()) {
            System.out.print(pqCopy.poll() + " ");
        }
        System.out.println();
    }
}
