package concurrency.criticalsection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CriticalSection {

    public static void main(String[] args) {
        PairManager
            pm1 = new SynchronizedPairManager(),
            pm2 = new CriticalSectionPairManager();

        testSynchronization(pm1, pm2);
    }

    public static void testSynchronization(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
            pm1 = new PairManipulator(pman1),
            pm2 = new PairManipulator(pman2);
        PairChecker
            pcheck1 = new PairChecker(pman1),
            pcheck2 = new PairChecker(pman2);

        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);

        System.out.println("pm1: " + pm1);
        System.out.println("pm2: " + pm2);
        System.exit(0);
    }

}
