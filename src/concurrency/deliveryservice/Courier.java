package concurrency.deliveryservice;

public class Courier implements Runnable {

    private DeliveryService deliveryService;

    public Courier(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            runTask();
        }
    }

    private void runTask() {
        try {
            sendPackage();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private void sendPackage() throws InterruptedException {
        waitForPackage();
        deliverPackage();
    }

    private void waitForPackage() throws InterruptedException {
        synchronized(this) {
            while (deliveryService.getPkg() == null) {
                wait();
            }
        }
    }

    private void deliverPackage() {
        System.out.println("Delivery package: " + deliveryService.getPkg());
        synchronized(deliveryService.getSender()) {
            deliveryService.setPkg(null);
            deliveryService.getSender().notifyAll();
        }
    }

}
