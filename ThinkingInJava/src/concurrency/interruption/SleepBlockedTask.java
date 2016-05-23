package concurrency.interruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SleepBlockedTask implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Task is asleep");
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting SleepBlockedTask()");
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new SleepBlockedTask());

        TimeUnit.SECONDS.sleep(2);
        future.cancel(true);
    }
}
