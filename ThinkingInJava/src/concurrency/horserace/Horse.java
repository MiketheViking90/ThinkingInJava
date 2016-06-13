package concurrency.horserace;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Horse implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private Random rand = new Random(47);

    @Override
    public void run() {
        try {
            System.out.println(this + " start");
            int timeout = rand.nextInt(2000);
            TimeUnit.MILLISECONDS.sleep(timeout);
            System.out.println(this + " finish");
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return "Horse " + id;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Horse horse = new Horse();
            exec.execute(horse);
        }
    }
}
