package concurrency.catchingexceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("test exception");
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new ExceptionThread());
    }
}
