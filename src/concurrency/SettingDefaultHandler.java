package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.domain.CustomUncaughtExceptionHandler;
import concurrency.domain.ExceptionThread2;

public class SettingDefaultHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(
                new CustomUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.execute(new ExceptionThread2());
    }
}
