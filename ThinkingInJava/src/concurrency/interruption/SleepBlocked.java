package concurrency.interruption;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting SleepBlocked.run()");
    }

}
