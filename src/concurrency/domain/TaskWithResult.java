package concurrency.domain;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int identifier) {
        id = identifier;
    }

    @Override
    public String call() throws Exception {
        return "TaskWithResult: " + id;
    }

}
