package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    static final int SIZE = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            WaitingTask waitTask = new WaitingTask(latch);
            exec.execute(waitTask);
        }
        for (int i = 0; i < SIZE; i++) {
            TaskPortion countDownTask = new TaskPortion(latch);
            exec.execute(countDownTask);
        }
        System.out.println("Started all tasks");
        exec.shutdown();
    }

}
