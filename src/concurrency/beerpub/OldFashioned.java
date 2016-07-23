package concurrency.beerpub;

public class OldFashioned {

    private boolean hasWhiskey = false;

    public synchronized void fill() {
        hasWhiskey = true;
        notifyAll();
    }

    public synchronized void empty() {
        hasWhiskey = false;
        notifyAll();
    }

    public synchronized void waitForFilling() throws InterruptedException {
        if (hasWhiskey == false) {
            wait();
        }
    }

    public synchronized void waitForEmptying() throws InterruptedException {
        if (hasWhiskey == true) {
            wait();
        }
    }
}
