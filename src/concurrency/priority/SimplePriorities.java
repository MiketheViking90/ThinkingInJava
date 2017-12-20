package concurrency.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable {

    private int countDown = 5;

    private int priority;
    private volatile double d;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);

        while (true) {
            for (int i = 0; i < 1000000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 100 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        es.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        es.shutdown();
    }
}
