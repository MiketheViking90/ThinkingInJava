package concurrency.beerpub;

import java.util.concurrent.TimeUnit;

public class Bartender implements Runnable {

    private Mug mug;

    public Bartender(Mug mug) {
        this.mug = mug;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println("Fill up mug");
                TimeUnit.MILLISECONDS.sleep(200);
                mug.fill();
                mug.waitForEmptying();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Ending Bartender task");
    }
}
