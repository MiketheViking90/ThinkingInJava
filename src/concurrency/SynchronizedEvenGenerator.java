package concurrency;

public class SynchronizedEvenGenerator extends IntGenerator {

    private int val = 0;

    @Override
    public synchronized int next() {
        ++val;
        ++val;

        return val;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            EvenChecker.test(new SynchronizedEvenGenerator());
        }
    }
}
