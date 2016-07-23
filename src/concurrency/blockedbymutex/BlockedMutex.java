package concurrency.blockedbymutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedMutex {

    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
    }

    public void interruptLock() {
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquired in interruptLock()");
        } catch (InterruptedException e) {
            System.out.println("Interrupted from lock acquisition in interruptLock()");
        }
    }

    public static void main(String[] args) {
        BlockedMutex bm = new BlockedMutex();
        bm.interruptLock();
    }
}
