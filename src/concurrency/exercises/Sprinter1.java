package concurrency.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Sprinter1 implements Runnable {

    private Sprinter2 nextSprinter;

    public Sprinter1(Sprinter2 sprinter) {
        this.nextSprinter = sprinter;
    }

    @Override
    public synchronized void run() {
        try {
            System.out.println("Sprinter 1 start");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Sprinter 1 finish");
            nextSprinter.recieveBaton();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Sprinter2 sprinter2 = new Sprinter2();
        Sprinter1 sprinter1 = new Sprinter1(sprinter2);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sprinter1);
        exec.execute(sprinter2);
    }
}
