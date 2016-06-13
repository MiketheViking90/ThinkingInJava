package concurrency.toast;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Jellier implements Runnable {

    private final BlockingQueue<Toast> jellyQueue, finishedQueue;

    public Jellier(BlockingQueue<Toast> jellyQueue, BlockingQueue<Toast> finishedQueue) {
        this.jellyQueue = jellyQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = jellyQueue.take();
                if (!toast.isJellyed()) {
                    toast.jelly();
                    System.out.println(toast + " JELLYED");
                }
                if (toast.isPeanutButtered()) {
                    finishedQueue.put(toast);
                } else {
                    jellyQueue.put(toast);
                    TimeUnit.MICROSECONDS.sleep(1);
                }
            }
        } catch(InterruptedException e) {

        }
    }
}
