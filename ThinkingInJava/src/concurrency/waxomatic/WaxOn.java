package concurrency.waxomatic;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exit via Thread interrupt");
        }
        System.out.println("Complete Wax On task");
    }

}
