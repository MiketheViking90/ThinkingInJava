package concurrency.domain;

public class InnerThread2 {

    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {

            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            @Override
            public String toString() {
                return name + ": " + countDown;
            }
        };
        t.start();
    }

}
