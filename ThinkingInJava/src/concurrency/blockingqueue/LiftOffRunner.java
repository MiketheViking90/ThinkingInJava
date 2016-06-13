package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

import concurrency.LiftOff;

public class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void put(LiftOff rocket) {
        try {
            rockets.put(rocket);
        } catch (InterruptedException e) {
            System.out.println("Interrupted putting rocket: " + rocket);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                System.out.println("Runner takes new rocket");
                rocket.run();
            }
         } catch (InterruptedException e) {
             System.out.println("Runner interrupted: " + e);
         }
        System.out.println("Exit from Runner");
    }

}
