package concurrency.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise6 implements Runnable {

    private final int id;

    public Exercise6(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        long sleep = (long) (Math.random() * 10000);
        sleep(sleep);
        Thread.yield();

        long runtime = System.currentTimeMillis() - start;
        System.out.println(id + ": " + runtime);
    }

    private void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            exec.execute(new Exercise6(i));
        }
        exec.shutdown();
    }

}
