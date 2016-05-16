package concurrency.domain;

import java.util.concurrent.TimeUnit;

public class InnerRunnable1 {

    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {
        private Thread t;
        private String name;

        public Inner(String name) {
            this.name = name;
            t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        @Override
        public String toString() {
            return name + ": " + countDown;
        }
    }

}
