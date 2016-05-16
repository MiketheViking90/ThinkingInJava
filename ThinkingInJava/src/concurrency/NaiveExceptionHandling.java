package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExceptionHandling {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("Handled exception");
        }
    }

}
