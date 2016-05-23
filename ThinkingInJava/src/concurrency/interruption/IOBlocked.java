package concurrency.interruption;

import java.io.IOException;
import java.io.InputStream;

public class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream is) {
        this.in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read(): ");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from I/O");
            } else {
                e.printStackTrace();
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }

}
