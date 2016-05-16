package concurrency.domain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sprinter implements Runnable {

    private static final String READY_FORMAT= "%d ready";
    private static final String SET_FORMAT= "%d set";
    private static final String RUNNING_FORMAT= "%d running";
    private static final String FINISH_FORMAT= "%d finished";

    private static int count = 0;

    private int id = count++;

    public Sprinter() {
        String msg = String.format(READY_FORMAT, id);
        System.out.println(msg);
    }

    @Override
    public void run() {
        String msg = String.format(SET_FORMAT, id);
        raceStep(msg);

        msg = String.format(RUNNING_FORMAT, id);
        raceStep(msg);

        msg = String.format(FINISH_FORMAT, id);
        raceStep(msg);
    }

    private void raceStep(String msg) {
        System.out.println(msg);
        Thread.yield();
    }

    public static void main(String[] args) {
        //executeWithThreads();
        executeWithExectorService();
    }

    private static void executeWithExectorService() {
        System.out.println("Client uses Executors");
        ExecutorService exe = Executors.newCachedThreadPool();
        exe.execute(new Sprinter());
        exe.execute(new Sprinter());
        exe.execute(new Sprinter());
        exe.execute(new Sprinter());
    }

    private static void executeWithThreads() {
        System.out.println("Client uses threads");

        Thread t1 = new Thread(new Sprinter());
        Thread t2 = new Thread(new Sprinter());
        Thread t3 = new Thread(new Sprinter());
        Thread t4 = new Thread(new Sprinter());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
