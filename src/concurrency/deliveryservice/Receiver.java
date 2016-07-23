package concurrency.deliveryservice;

public class Receiver implements Runnable {

    private final DeliveryService deliveryService;

    public Receiver(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            receivePackage();
        }
    }

    private void receivePackage() {
        try {
            waitForPackage();
            System.out.println("Package seen at doorstep");
            pickUpPackage();
        } catch (InterruptedException e) {
            String msg = this.getClass().getSimpleName() + e;
            System.out.println(e);
        }
    }

    private void waitForPackage() throws InterruptedException {
        synchronized(this) {
            boolean isPackageSent = (deliveryService.getPkg() == null);
            while (!isPackageSent) {
                wait();
            }
        }
    }

    private void pickUpPackage() {
        Courier courier = deliveryService.getCourier();
        synchronized(courier) {
            deliveryService.packageStatusReceived();
            courier.notifyAll();
        }
    }

}
