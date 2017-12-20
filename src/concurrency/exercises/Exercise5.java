package concurrency.exercises;

import generics.FibonnacciGenerator;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Exercise5 implements Callable<Integer> {

    private final int n;

    public Exercise5(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        FibonnacciGenerator fb = new FibonnacciGenerator(n);
        return sum(fb.getFibs());
    }

    private int sum(int[] fibs) {
        int sum = 0;
        for (int i : fibs) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 3; i < 20; i++) {
            Callable call = new Exercise5(i);
            Future<Integer> future = exec.submit(call);
            futures.add(future);
        }

        for (Future<Integer> future : futures) {
            LocalDateTime start = LocalDateTime.now();
            int i = futures.get(2).get();
            LocalDateTime end = LocalDateTime.now();
            long diff = start.until(end, ChronoUnit.MILLIS);
            System.out.println(i + ": time: " + diff);
        }
    }
}
