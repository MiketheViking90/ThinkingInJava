package concurrency.interruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Interrupting {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        //test(new SleepBlocked());
        test(new IOBlocked(System.in));
        //test(new SynchronizeBlocked());

        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }

    private static void test(Runnable r) throws InterruptedException {
        Future<?> future = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(1500);

        System.out.println("Interrupting " + r.getClass().getName());
        future.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }
}
