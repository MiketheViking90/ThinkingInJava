package concurrency.checkingforinterrupt;

import java.util.concurrent.TimeUnit;

public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BlockedCleanUp());
        t.start();
        TimeUnit.MILLISECONDS.sleep(5000);
        t.interrupt();
    }

}
