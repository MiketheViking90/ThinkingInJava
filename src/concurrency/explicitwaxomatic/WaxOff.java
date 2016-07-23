package concurrency.explicitwaxomatic;

import java.util.concurrent.TimeUnit;

public class WaxOff implements  Runnable {

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(100);
                car.buffed();
                car.waitForWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println("WaxOff interrupted: " + e);
        }
    }

}
