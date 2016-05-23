package concurrency.interruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SynchronizeBlockedTask implements Runnable {

    public SynchronizeBlockedTask() {
        System.out.println("Lock is held");
        new Thread() {
            @Override
            public void run() {
                holdLock();
            }
        }.start();
    }

    private synchronized void holdLock() {
        while (true) {
            Thread.yield();
        }
    }

    @Override
    public void run() {
        System.out.println("Trying to obtain lock");
        holdLock();
        System.out.println("Exiting Synchronized lock");
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new SynchronizeBlockedTask());

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Sending interruption to task");
        future.cancel(true);
        System.out.println("Interruption sent");
    }
}
