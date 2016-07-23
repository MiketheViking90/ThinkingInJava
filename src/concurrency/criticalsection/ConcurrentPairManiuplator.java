package concurrency.criticalsection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentPairManiuplator implements Runnable {

    private Pair pair;

    public ConcurrentPairManiuplator(Pair pair) {
        this.pair = pair;
    }

    @Override
    public void run() {
        while (true) {
            pair.incrementX();
            pair.incrementY();
            try {
                pair.checkState();
            } catch (IllegalStateException e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Pair pair = new Pair();
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            exec.execute(new ConcurrentPairManiuplator(pair));
        }
    }
}
