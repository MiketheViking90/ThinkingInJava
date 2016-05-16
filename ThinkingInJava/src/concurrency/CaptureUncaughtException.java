package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.domain.ExceptionHandlerThreadFactory;
import concurrency.domain.ExceptionThread2;

public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(
                new ExceptionHandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
