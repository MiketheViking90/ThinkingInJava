package concurrency.blockedbymutex;

public class MultiLock {

    public synchronized void outerLock(int count) {
        if (count-- > 0) {
            System.out.println("outerLock() calling innerLock() with count: " + count);
            innerLock(count);
        }
    }

    public synchronized void innerLock(int count) {
        if (count-- > 0) {
            System.out.println("innerLock() calling outerLock() with count " + count);
            outerLock(count);
        }
    }

    public static void main(String[] args) {
        final MultiLock ml = new MultiLock();

        new Thread() {
            @Override
            public void run() {
                ml.outerLock(10);
            }
        }.start();

    }
}
