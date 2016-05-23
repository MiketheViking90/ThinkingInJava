package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {

    private int i = 0;

    public synchronized int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest test = new AtomicityTest();
        exec.execute(test);

        while (true) {
            int val = test.getValue();
            System.out.println(val);
            if (val % 2 != 0) {
                System.err.println(val);
                System.exit(0);
            }
        }
    }
}
