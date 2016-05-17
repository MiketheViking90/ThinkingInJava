package concurrency.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataSource {

    private int val = 0;

    public int next() {
        ++val;
        ++val;

        return val;
    }

    public static void main(String[] args) {
        DataSource source = new DataSource();
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new DataConsumer(source));
        }
    }
}
