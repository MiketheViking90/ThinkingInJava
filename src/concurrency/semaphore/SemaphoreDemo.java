package concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    private final static int SIZE = 25;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> fatPool = new Pool<>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < SIZE; i++) {
            CheckoutTask<Fat> task = new CheckoutTask<>(fatPool);
            exec.execute(task);
        }
        System.out.println("All Checkout Tasks created");

        List<Fat> fatList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Fat fat = fatPool.checkOut();
            System.out.println(i + ": main() thread checed out: " + fat);
            fat.operation();
            fatList.add(fat);
        }

        Future<?> blocked = exec.submit(new Runnable(){
            @Override
            public void run() {
                try {
                    fatPool.checkOut();
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        System.out.println("Checking in objecgts in " + fatList);
        for (Fat f : fatList) {
            fatPool.checkIn(f);
        }
        for (Fat f : fatList) {
            fatPool.checkIn(f);
        }
        exec.shutdownNow();
    }
}
