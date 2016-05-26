package concurrency.checkingforinterrupt;

import java.util.concurrent.TimeUnit;

public class BlockedCleanUp implements Runnable {

    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                NeedsCleanup n1 = new NeedsCleanup(1);

                try {
                    System.out.println("Block Thread.sleep()");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);

                    try {
                        System.out.println("\tNon-block resource-intensive computation");
                        for (int i = 0; i < 2500000; i++) {
                            d = (d + (Math.PI + Math.E) / d);
                        }
                        System.out.println("\tFinish resource-intensive computation");
                    } finally {
                        n2.cleanup();
                    }

                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exit via while() test");
        } catch (InterruptedException e) {
            System.out.println("Exit via Interruption " + e);
        }
    }
}
