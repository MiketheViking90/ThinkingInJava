package concurrency.medirestaurant;

public class PetraChef implements Runnable {

    private static final int NUMBER_OF_FOOD_SUPPLIES = 10;

    private int count = 0;
    private final PetraMediterraneanBistro bistro;

    public PetraChef(PetraMediterraneanBistro bistro) {
        this.bistro = bistro;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                runTaskAsChef();
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted " + e);
        }
    }

    private void runTaskAsChef() throws InterruptedException {
        waitForKebobConsumption();
        checkSupplies();
        produceKebob();
    }

    private synchronized void waitForKebobConsumption() throws InterruptedException {
        while (!bistro.hasKebob()) {
            wait();
        }
    }

    private void checkSupplies() {
        if (++count == NUMBER_OF_FOOD_SUPPLIES) {
            System.out.println("Out of food. Closing shop");
            bistro.close();
        }
    }

    private void produceKebob() {
        System.out.println("Cooking kebob");
        PetraWaiter waiter = bistro.getWaiter();
        synchronized(waiter) {
            bistro.setKebob(new Kebob(count));
            waiter.notifyAll();
        }
    }

}
