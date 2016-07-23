package concurrency.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Eater implements Runnable {

    private static int count = 0;
    private static Random rand = new Random(47);

    private final int id = count++;
    private int numEaten = 0;
    private CyclicBarrier barrier;

    public Eater(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                synchronized (this) {
                    numEaten += rand.nextInt(3);
                }
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println("Eater interrutped: " + e);
            }
        }
    }

    public synchronized int getNumEaten() {
        return numEaten;
    }

    public String eat() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numEaten; i++) {
            sb.append("*");
        }
        sb.append(id);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Eater " + id;
    }
}
