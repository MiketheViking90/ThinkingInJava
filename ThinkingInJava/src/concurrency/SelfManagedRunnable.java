package concurrency;

public class SelfManagedRunnable implements Runnable {

    private static final String TO_STRING_FORMAT = "%s: (%d)";

    private int countDown = 5;
    private Thread t = new Thread(this);

    public SelfManagedRunnable() {
        t.start();
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT,
                Thread.currentThread().getName(),
                countDown);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManagedRunnable();
        }
    }
}
