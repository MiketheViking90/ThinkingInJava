package concurrency.exercises;

import generics.FibonnacciGenerator;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class Exercise2 implements Runnable {

    private static int count = 0;

    private final int n;
    private final int id = count++;

    @Override
    public void run() {
        FibonnacciGenerator fb = new FibonnacciGenerator(n);
        Thread.yield();
        System.out.println("#" + id + Arrays.toString(fb.getFibs()));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Exercise2(6)).start();
        }
        System.out.println("Start Fibo");
    }

}
