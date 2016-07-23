package concurrency.toast;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class PeanutButterer implements Runnable {

    private final BlockingQueue<Toast> jammedQueue, finishedQueue;

    public PeanutButterer(BlockingQueue<Toast> jammedQueue,
            BlockingQueue<Toast> finishedQueue) {
        this.jammedQueue = jammedQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = jammedQueue.take();
                if (!toast.isPeanutButtered()) {
                    System.out.println(toast + " PEANUT BUTTERED");
                    toast.peanutButter();
                }
                if (toast.isJellyed()) {
                    toast.isPeanutButtered();
                    finishedQueue.put(toast);
                } else {
                    jammedQueue.put(toast);
                    TimeUnit.MICROSECONDS.sleep(1);
                }
            }
        } catch(InterruptedException e) {
            System.out.println("Peanut Butterer interrupted: " + e);
        }
        System.out.println("Peanut Butterer off");
    }
}
