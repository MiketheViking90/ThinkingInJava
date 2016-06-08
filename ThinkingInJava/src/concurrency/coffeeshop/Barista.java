package concurrency.coffeeshop;

import java.util.concurrent.TimeUnit;

public class Barista implements Runnable {

    public static final int MAX_DRINKS_PER_SESSION = 10;

    private final Coffeeshop coffeeshop;
    private int count = 0;

    public Barista(Coffeeshop coffeeshop) {
        this.coffeeshop = coffeeshop;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized(this) {
                    while(coffeeshop.hasCoffee()) {
                        wait();
                    }
                }
                if (++count == MAX_DRINKS_PER_SESSION) {
                    System.out.println("Closing shop");
                    coffeeshop.exec.shutdownNow();
                }
                synchronized(coffeeshop.getWaiter()) {
                    coffeeshop.setCoffee(new Coffee(count));
                    coffeeshop.getWaiter().notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Barista interrupted: " + e);
        }
    }

    private void runTaskInThread() throws InterruptedException {
        while(!Thread.interrupted()) {
            waitForCoffeeToBeConsumed();
            checkWorkDone();
            makeCoffeeForRestaurant();
        }
    }

    private void checkWorkDone() {
        if (++count == MAX_DRINKS_PER_SESSION) {
            System.out.println("Closing shop for the day");
            coffeeshop.closeShop();
        }
    }

    private void waitForCoffeeToBeConsumed() throws InterruptedException {
        synchronized(this) {
            if (coffeeshop.hasCoffee()) {
                wait();
            }
        }
    }

    private void makeCoffeeForRestaurant() throws InterruptedException {
        Waiter waiter = coffeeshop.getWaiter();
        synchronized(waiter) {
            Coffee coffee = makeCoffee();
            coffeeshop.setCoffee(coffee);
            waiter.notifyAll();
        }
        TimeUnit.MILLISECONDS.sleep(100);
    }

    private Coffee makeCoffee() {
        Coffee coffee = new Coffee(count);
        System.out.println("Barista made coffee " + coffee);
        return coffee;
    }

}
