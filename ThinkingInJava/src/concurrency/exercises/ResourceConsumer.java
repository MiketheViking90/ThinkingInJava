package concurrency.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ResourceConsumer implements Runnable {

    private SharedResource resource;

    public ResourceConsumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            resource.useResource();
            System.out.println("Consumer blocks on sleep");
            TimeUnit.SECONDS.sleep(2);
            resource.yieldResource();
            System.out.println("Consumer opens resource " + resource.isOpen());
            Thread.yield();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        System.out.println(resource.isOpen());
        ResourceConsumer consumer = new ResourceConsumer(resource);
        ResourceCheck check = new ResourceCheck(resource);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(consumer);
        exec.execute(check);
    }

}
