package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class WaitingTask implements Runnable {

    private static int counter = 0;

    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch(InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return "WaitingTask " + id;
    }
}
