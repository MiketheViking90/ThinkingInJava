package containers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import generics.abst.Generator;

public class QueueBehavior {

    private static int count = 10;

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        PriorityQueue<String> pq = new PriorityQueue<String>();
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(10);
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<>();
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>();
        PriorityBlockingQueue<String> pbq = new PriorityBlockingQueue<>();

        test(ll, new Gen());
        test(pq, new Gen());
        test(abq, new Gen());
        test(clq, new Gen());
        test(lbq, new Gen());
        test(pbq, new Gen());
    }

    private static <T> void test(Queue<T> q, Generator<T> gen) {
        for (int i = 0; i < count; i++) {
            q.offer(gen.generate());
        }
        while (q.peek() != null) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }

    static class Gen implements Generator<String> {
        String[] s = ("one two three four five six seven" +
                " eight nine ten").split(" ");
        int i;

        @Override
        public String generate() {
            return s[i++];
        }
    }

}
