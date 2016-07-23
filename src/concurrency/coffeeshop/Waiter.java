package concurrency.coffeeshop;

public class Waiter implements Runnable {

    private final Coffeeshop coffeeshop;

    public Waiter(Coffeeshop coffeeshop) {
        this.coffeeshop = coffeeshop;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized(this) {
                    while (!coffeeshop.hasCoffee()) {
                        wait();
                    }
                }
                System.out.println("Waiter picked up coffee " + coffeeshop.getCoffee());
                synchronized(coffeeshop.getBarista()) {
                    coffeeshop.consumeCoffee();
                    coffeeshop.getBarista().notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Waiter interrupted. " + e);
        }
    }
//
//    private void runTaskInThread() throws InterruptedException {
//        waitForCoffeeToBeProduced();
//        deliverCoffeeForConsumption();
//    }
//
//    private void waitForCoffeeToBeProduced() throws InterruptedException {
//        synchronized(this) {
//            while (!coffeeshop.hasCoffee()) {
//                wait();
//            }
//        }
//    }
//
//    private void deliverCoffeeForConsumption() {
//        System.out.println("Waiter delivery coffee " + coffeeshop.getCoffee());
//        Barista barista = coffeeshop.getBarista();
//        synchronized(barista) {
//            coffeeshop.consumeCoffee();
//            barista.notifyAll();
//        }
//    }

}
