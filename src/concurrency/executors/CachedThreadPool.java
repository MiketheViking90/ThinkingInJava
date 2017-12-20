package concurrency.executors;

import concurrency.tasks.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {

        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exe.execute(new LiftOff());
        }

        exe.shutdown();
    }
}
