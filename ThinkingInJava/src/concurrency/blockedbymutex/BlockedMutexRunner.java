package concurrency.blockedbymutex;

import java.util.concurrent.TimeUnit;

import lombok.Setter;

public class BlockedMutexRunner implements Runnable {

    @Setter BlockedMutex bm;

    public BlockedMutexRunner() {
        bm = new BlockedMutex();
    }

    public void testWait() throws InterruptedException {
        System.out.println("Start wait");
        try {
            wait(5);
            notifyAll();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        System.out.println("End wait");
    }

    @Override
    public void run() {
        System.out.println("Waiting for interruptLock() in Thread");
        bm.interruptLock();
        System.out.println("Reentrant lock has been interrupted from outside Thread");
    }

    public static void main(String[] args) throws InterruptedException {
        BlockedMutexRunner blockedRunner = new BlockedMutexRunner();
        Thread t = new Thread(blockedRunner);
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing interruption from main Thread");
        t.interrupt();

        blockedRunner.testWait();
    }

}
