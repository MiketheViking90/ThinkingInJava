package concurrency.beerpub;

import java.util.concurrent.TimeUnit;

public class Drinker implements Runnable {

    private Mug mug;

    public Drinker(Mug mug) {
        this.mug = mug;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                mug.waitForFilling();
                System.out.println("Drink the beer");
                TimeUnit.MILLISECONDS.sleep(200);
                mug.empty();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Ending Drinker task");
    }

}
