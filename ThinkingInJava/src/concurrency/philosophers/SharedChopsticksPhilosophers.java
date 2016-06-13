package concurrency.philosophers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SharedChopsticksPhilosophers {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        BlockingQueue<Chopstick> chopsticks = new LinkedBlockingQueue<>();
        for (int i = 0; i < 5; i++) {
            chopsticks.put(new Chopstick());
        }
        for (int i = 0; i < 5; i++) {
            ShareChopstickPhilosopher philosopher =
                    new ShareChopstickPhilosopher(chopsticks, i, 0);
            exec.execute(philosopher);
        }
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
