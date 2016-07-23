package concurrency.scheduledexecutor;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Terminater implements Runnable {

    private ScheduledThreadPoolExecutor scheduler;

    public Terminater(ScheduledThreadPoolExecutor scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
        System.out.println("Terminating");
        scheduler.shutdownNow();
    }
}
