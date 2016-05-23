package concurrency.criticalsection;

import java.util.concurrent.locks.Lock;

public class LockPairManager2 extends PairManager {

    private Lock lock;

    @Override
    public void increment() {
        Pair temp;
        lock.lock();

        try {
            pair.incrementX();
            pair.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }

}
