package concurrency.exercises;

public class DataConsumer implements Runnable {

    private DataSource dataSource;

    public DataConsumer(DataSource source) {
        dataSource = source;
    }

    @Override
    public void run() {
        while (true) {
            int val = dataSource.next();
            if (val % 2 != 0) {
                System.err.println(val + " is not even");
                return;
            }
        }
    }

}
