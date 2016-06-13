package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

import concurrency.LiftOff;

public class QueueTaskSetter implements Runnable {

    private final BlockingQueue<LiftOff> queue;
    private int count = 1;

    public QueueTaskSetter(BlockingQueue<LiftOff> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = new LiftOff(count++);
                queue.put(rocket);
            }
        } catch (InterruptedException e) {
            System.out.println("Setter interrupted: " + e);
        }
    }
}
