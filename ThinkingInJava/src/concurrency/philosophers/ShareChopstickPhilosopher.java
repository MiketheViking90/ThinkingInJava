package concurrency.philosophers;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ShareChopstickPhilosopher implements Runnable {

    BlockingQueue<Chopstick> chopsticks;
    private Chopstick left;
    private Chopstick right;

    private final int id;
    private final int ponderFactor;

    private Random rand = new Random(47);

    public ShareChopstickPhilosopher(BlockingQueue<Chopstick> chopsticks, int id, int ponderFactor) {
        this.chopsticks = chopsticks;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                think();
                pickupChopsticks();
                eat();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }


    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    private void think() throws InterruptedException {
        System.out.println(this + " thinking");
        pause();
    }

    private void pickupChopsticks() throws InterruptedException {
        System.out.println(this + " taking right chopstick");
        right = chopsticks.take();
        right.take();

        System.out.println(this + " taking left chopstick");
        left = chopsticks.take();
        left.take();
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " eating");
        pause();

        right.drop();
        left.drop();
        chopsticks.put(right);
        chopsticks.put(left);
        right = null;
        left = null;
    }

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }
        int pauseTime = rand.nextInt(ponderFactor * 250);
        TimeUnit.MILLISECONDS.sleep(pauseTime);
    }

}
