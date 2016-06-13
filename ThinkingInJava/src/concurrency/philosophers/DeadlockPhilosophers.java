package concurrency.philosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadlockPhilosophers {

    public static void main(String[] args) throws InterruptedException {
        int ponder = 0;
        int size = 5;

        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[5];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            Philosopher philosopher;
            if (i == 0) {
                philosopher = new Philosopher(
                        chopsticks[(i + 1) % size], chopsticks[i], i, ponder);
            } else {
                philosopher = new Philosopher(
                        chopsticks[i], chopsticks[(i + 1) % size], i, ponder);
            }
            exec.execute(philosopher);
        }
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }

}
