package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import concurrency.LiftOff;

public class QueueTaskRunner implements Runnable {

    private final BlockingQueue<LiftOff> queue;

    public QueueTaskRunner(BlockingQueue<LiftOff> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = queue.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("Runner interrupted: " + e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        BlockingQueue<LiftOff> queue = new LinkedBlockingQueue<>();

        QueueTaskRunner runner = new QueueTaskRunner(queue);
        QueueTaskSetter setter = new QueueTaskSetter(queue);

        exec.execute(runner);
        exec.execute(setter);
        TimeUnit.MILLISECONDS.sleep(200);
        exec.shutdownNow();
    }

}
