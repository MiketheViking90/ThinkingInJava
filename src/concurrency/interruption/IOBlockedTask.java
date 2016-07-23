package concurrency.interruption;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class IOBlockedTask implements Runnable {

    private InputStream is;

    public IOBlockedTask(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("Blocked by IO Read");
            is.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted");
            } else {
                e.printStackTrace();
            }
        }
        System.out.println("Exiting IO Lock");
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new IOBlockedTask(System.in));

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting task");
        future.cancel(true);
        System.out.println("Sent interruption to task " + future.getClass().getName());
    }
}
