package concurrency.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskPortion implements Runnable {

    private static int counter = 0;
    private static Random rand = new Random(47);

    private final int id = counter++;
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch(InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return "TaskPortion " + id;
    }

    private void doWork() throws InterruptedException {
        int sleepCount = rand.nextInt(2000);
        TimeUnit.MILLISECONDS.sleep(sleepCount);
        System.out.println(this + " complete");
    }

}
