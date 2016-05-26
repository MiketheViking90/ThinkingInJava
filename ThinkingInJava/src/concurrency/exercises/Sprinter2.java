package concurrency.exercises;

import java.util.concurrent.TimeUnit;

public class Sprinter2 implements Runnable {

    public synchronized void recieveBaton() {
        notifyAll();
    }

    private synchronized void waitForBaton() throws InterruptedException {
        System.out.println("Sprinter 2 Sitting on starting block");
        wait();
    }

    @Override
    public void run() {
        try {
            waitForBaton();
            System.out.println("Sprinter 2 obtained baton from handshake");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Sprinter 2 finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
