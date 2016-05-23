package concurrency.interruption;

public class SynchronizeBlocked implements Runnable {

    public SynchronizeBlocked() {
        new Thread() {
            @Override
            public void run() {
                holdLock();
            }
        }.start();
    }

    public synchronized void holdLock() {
        while (true) {
            Thread.yield();
        }
    }

    @Override
    public void run() {
        System.out.println("Try to call holdLock()");
        holdLock();
        System.out.println("Exiting SynchronizedLock.run()");
    }

}
