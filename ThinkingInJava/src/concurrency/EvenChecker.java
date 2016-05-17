package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator gen;
    private final int id;

    public EvenChecker(IntGenerator gen, int id) {
        this.gen = gen;
        this.id = id;
    }

    @Override
    public void run() {
        while (!gen.isCancelled()) {
            int val = gen.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                gen.cancel();
            }
        }
    }

    static void test(IntGenerator gen, int count) {
        System.out.println("Start test");
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gen, i));
        }
        exec.shutdown();
    }

    static void test(IntGenerator gen) {
        test(gen, 10);
    }

    public static void main(String[] args) {
    }
}
