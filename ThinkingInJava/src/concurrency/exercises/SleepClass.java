package concurrency.exercises;

import java.util.concurrent.TimeUnit;

public class SleepClass {

    public void goToSleep() {
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
