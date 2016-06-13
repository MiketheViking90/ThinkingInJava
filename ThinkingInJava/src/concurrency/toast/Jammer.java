package concurrency.toast;

import java.util.concurrent.BlockingQueue;

public class Jammer implements Runnable {

    private final BlockingQueue<Toast> butteredQueue, jammedQueue;

    public Jammer(BlockingQueue<Toast> butteredQueue, BlockingQueue<Toast> jammedQueue) {
        this.butteredQueue = butteredQueue;
        this.jammedQueue = jammedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = butteredQueue.take();
                toast.jam();
                System.out.println(toast);
                jammedQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted: " + e);
        }
        System.out.println("Jammer off");
    }

}
