package concurrency.catchingexceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExceptionHandling {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        try {
            es.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            System.out.println("handled exception");
        }
    }

}
