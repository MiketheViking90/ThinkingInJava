package concurrency.deliveryservice;

public class Sender implements Runnable {

    private int count = 0;
    private DeliveryService deliveryService;

    public Sender(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public void run() {
        try {
            sendPackageForDelivery();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private void sendPackageForDelivery() throws InterruptedException {
        while (!Thread.interrupted()) {
            waitForCourier();
            checkForBusinessHours();
            sendPackage();
        }
    }

    private void waitForCourier() throws InterruptedException {
        synchronized(this) {
            boolean isPackagePostOrder = ((deliveryService.getPkg() == null)
                    || deliveryService.isPackageInTransit());
            while (isPackagePostOrder) {
                wait();
            }
        }
    }

    private void checkForBusinessHours() {
        if (++count == 10) {
            System.out.println("Deliveries closed for the day");
            deliveryService.getExec().shutdownNow();
        }
    }

    private void sendPackage() {
        System.out.println("Sender drafting letter");
        synchronized(deliveryService.getCourier()) {
            deliveryService.setPkg(new Package(count));
            deliveryService.getCourier().notifyAll();
        }
    }

}
