package concurrency.toast;

import java.util.concurrent.BlockingQueue;

public class Butterer implements Runnable {

    private final BlockingQueue<Toast> dryQueue, butteredQueue;

    public Butterer(BlockingQueue<Toast> dryQueue,
            BlockingQueue<Toast> butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted: " + e);
        }
        System.out.println("Butterer off");
    }

}
