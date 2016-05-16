package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es1 = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            es1.execute(new LiftOff());
        }

        es.shutdown();
    }
}
