package concurrency.toast;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {

    private final BlockingQueue<Toast> toastQueue;
    private int count = 0;

    public Toaster(BlockingQueue<Toast> toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted: " + e);
        }
        System.out.println("Toaster off");
    }
}
