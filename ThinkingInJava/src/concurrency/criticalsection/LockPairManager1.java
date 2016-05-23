package concurrency.criticalsection;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPairManager1 extends PairManager {

        private Lock lock = new ReentrantLock();

        @Override
        public void increment() {
            try {
                pair.incrementX();
                pair.incrementY();
                store(pair);
            } finally {
                lock.unlock();
            }
        }

}
