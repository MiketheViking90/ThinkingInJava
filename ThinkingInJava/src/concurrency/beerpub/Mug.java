package concurrency.beerpub;

public class Mug {

    public boolean isFull = false;

    public synchronized void fill() {
        isFull = true;
        notifyAll();
    }

    public synchronized void empty() {
        isFull = false;
        notifyAll();
    }

    public synchronized void waitForFilling() throws InterruptedException {
        while (isFull == false) {
            wait();
        }
    }

    public synchronized void waitForEmptying() throws InterruptedException {
        while (isFull == true) {
            wait();
        }
    }

}
