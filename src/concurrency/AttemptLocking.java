package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

    private Lock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;

        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
            System.out.println("tryLock(2, seconds): " + captured);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (captured) {
                lock.unlock();
                System.out.println("unlocked timed lock");
            }
        }
    }

    public static void main(String[] args) {
        AttemptLocking attempt = new AttemptLocking();
        attempt.timed();
        attempt.untimed();

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                attempt.lock.lock();
                System.out.println("lock acquired");
            }
        }.start();
        Thread.yield();
        attempt.untimed();
        attempt.timed();
    }
}
