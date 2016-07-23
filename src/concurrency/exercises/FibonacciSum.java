package concurrency.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciSum implements Callable<Integer> {

    private int length;

    public FibonacciSum(int n) {
        length = n;
    }

    @Override
    public Integer call() {
        return getSum();
    }

    private int getSum() {
        if (length < 1) {
            return 1;
        }
        if (length == 2) {
            return 2;
        }

        int[] fibs = new int[length];
        fibs[0] = 1;
        fibs[1] = 1;

        for (int i = 2; i < length; i++) {
            fibs[i] = (fibs[i - 1] + fibs[i - 2]);
        }

        return fibs[length - 1];
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> results = getValues(exec);
        printResults(results);
        exec.shutdown();
    }

    private static void printResults(List<Future<Integer>> results) {
        for (Future<Integer> sum : results) {
            try {
                System.out.println(sum.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Future<Integer>> getValues(ExecutorService exec) {
        List<Future<Integer>> results = new ArrayList<Future<Integer>>();
        Random rand = new Random(47);

        for (int i = 0; i < 5; i++) {
            FibonacciSum fs = new FibonacciSum(rand.nextInt(20));
            Future<Integer> res = exec.submit(fs);
            results.add(res);
        }

        return results;
    }

}
