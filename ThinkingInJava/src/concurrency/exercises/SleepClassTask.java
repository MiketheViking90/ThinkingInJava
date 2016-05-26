package concurrency.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SleepClassTask implements Runnable {

    private SleepClass sleepClass = new SleepClass();

    @Override
    public void run() {
        sleepClass.goToSleep();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new SleepClassTask());

        System.out.println("Interrupting sleep");
        TimeUnit.SECONDS.sleep(1);
        future.cancel(true);
        System.out.println("Interrupted sleep");
    }

}
