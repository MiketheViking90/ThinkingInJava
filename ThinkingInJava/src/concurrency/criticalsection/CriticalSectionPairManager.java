package concurrency.criticalsection;

public class CriticalSectionPairManager extends PairManager {

    @Override
    public void increment() {
        Pair tmp;
        synchronized(this) {
            pair.incrementX();
            pair.incrementY();

            tmp = getPair();
        }
        store(tmp);
    }

}
