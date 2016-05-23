package concurrency.criticalsection;

public class SynchronizedPairManager extends PairManager {

    @Override
    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();

        store(getPair());
    }

}
