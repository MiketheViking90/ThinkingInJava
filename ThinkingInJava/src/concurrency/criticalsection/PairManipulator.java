package concurrency.criticalsection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PairManipulator implements Runnable {

    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() +
                " checkCounter = " + pm.checkCounter.get();
    }

    public static void main(String[] args) {
        PairManager pm1 = new SynchronizedPairManager();
        PairManager pm2 = new CriticalSectionPairManager();
        PairManipulator pman1 = new PairManipulator(pm1);
        PairManipulator pman2 = new PairManipulator(pm2);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(pman1);
        exec.execute(pman2);
    }

}
