package concurrency.medirestaurant;

public class PetraWaiter implements Runnable {

    private final PetraMediterraneanBistro bistro;

    public PetraWaiter(PetraMediterraneanBistro bistro) {
        this.bistro = bistro;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                runTaskAsWaiter();
            }
        } catch (InterruptedException e) {
            System.out.println("Waiter interrupted " + e);
        }
    }

    private void runTaskAsWaiter() throws InterruptedException {
        waitForKebobToBeProduced();
        deliverKebob();
    }

    private void waitForKebobToBeProduced() throws InterruptedException {
        synchronized(this) {
            while(!bistro.hasKebob()) {
                wait();
            }
        }
    }

    private void deliverKebob() {
        System.out.println("Waiter picked up kebob: " + bistro.getKebob());
        PetraBusBoy busboy = bistro.getBusBoy();
        synchronized(busboy) {
            bistro.setKebob(null);
            bistro.getTable().seatGuests();
            busboy.notifyAll();
        }
    }

}
