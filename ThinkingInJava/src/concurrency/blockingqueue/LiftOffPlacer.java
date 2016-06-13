package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

import concurrency.LiftOff;

public class LiftOffPlacer implements Runnable {

    BlockingQueue<LiftOff> rockets;

    public LiftOffPlacer(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Placer putting new rocket");
                    rockets.put(new LiftOff(5));
                }
                return;
            }
        } catch (InterruptedException e) {
            System.out.println("Placer interrupted: " + e);
        }
    }

}
