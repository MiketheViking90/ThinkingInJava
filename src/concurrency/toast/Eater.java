package concurrency.toast;

import java.util.concurrent.BlockingQueue;

public class Eater implements Runnable {

    private final BlockingQueue<Toast> readyQueue;
    private int count = 0;

    public Eater(BlockingQueue<Toast> readyQueue) {
        this.readyQueue = readyQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = readyQueue.take();
                verifyToast(toast);
                System.out.println("CHOMP! " + toast);
            }
        } catch(InterruptedException e) {
            System.out.println("Eater interrupted: " + e);
        }
        System.out.println("Eater done");
    }

    private void verifyToast(Toast toast) {
        if (count++ != toast.getId()) {
            throw new IllegalStateException(toast + " is not finished");
        }
    }

}
