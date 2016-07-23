package concurrency.notifyvsnotifyall;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotifyVsNotifyAll {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            boolean notify = true;

            @Override
            public void run() {
                if (notify) {
                    System.out.println("\tnotify() ");
                    Task.blocker.sendNotify();
                    notify = false;
                } else {
                    System.out.println("\tnotifyAll() ");
                    Task.blocker.sendNotifyAll();
                    notify = true;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 400, 400);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Timer cancelled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.blocker.notifyAll()");
        Task2.blocker.notifyAll();
    }

}
