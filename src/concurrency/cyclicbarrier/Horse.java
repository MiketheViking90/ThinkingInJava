package concurrency.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable {

    private static Random rand = new Random(47);
    private static int counter = 0;

    private final int id = counter++;
    private CyclicBarrier barrier;
    private int strides = 0;

    public Horse(CyclicBarrier bar) {
        barrier = bar;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized(this) {
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        } catch(InterruptedException | BrokenBarrierException e) {
            System.out.println(this + " interrupted:" + e);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id;
    }

    public String tracks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            sb.append("*");
        }
        sb.append(id);
        return sb.toString();
    }

}
