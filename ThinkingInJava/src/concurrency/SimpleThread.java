package concurrency;

public class SimpleThread extends Thread {

    private static final String TO_STRING_FORMAT = "#%s: (%d)";
    private static int threadCount = 0;
    private int countDown = 5;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, getName(), countDown);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
