package concurrency.blockingqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import concurrency.LiftOff;

public class TestBlockingQueues {

    private static void getKey() {
        try {
            new BufferedReader(
                    new InputStreamReader(System.in))
                        .readLine();
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
    }

    private static void getKey(String msg) {
        System.out.println(msg);
        getKey();
    }

    private static void test(String msg,
            BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();

        LiftOffPlacer placer = new LiftOffPlacer(queue);
        Thread t1 = new Thread(placer);
        t1.start();

        getKey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        t1.interrupt();
        System.out.println("Finished " + msg + ")");
    }

    public static void main(String[] args) {
        //test("LinkedBlockingQ", new LinkedBlockingQueue<LiftOff>());
        //test("ArrayBLockignQ", new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQ", new SynchronousQueue<LiftOff>());
    }

}
