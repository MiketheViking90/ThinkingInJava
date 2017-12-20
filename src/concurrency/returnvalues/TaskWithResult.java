package concurrency.returnvalues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        return "result: " + id;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<String> result = exec.submit(new TaskWithResult(i));
            results.add(result);
        }

        for (Future<String> future : results) {
            try {
                String str = future.get();
                System.out.println(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
