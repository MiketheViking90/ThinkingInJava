package concurrency.explicitwaxomatic;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            System.out.println("Wax on!");
            TimeUnit.MILLISECONDS.sleep(100);
            car.waxed();
            car.waitForBuffing();
        } catch (InterruptedException e) {
            System.out.println("WaxOn interrupted: " + e);
        }
    }
}
