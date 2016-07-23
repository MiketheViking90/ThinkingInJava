package concurrency.criticalsection;

public class LockPairManagerTest {

    public static void main(String[] args) {
        PairManager
            pman1 = new LockPairManager1(),
            pman2 = new LockPairManager2();

        CriticalSection.testSynchronization(pman1, pman2);
    }
}
