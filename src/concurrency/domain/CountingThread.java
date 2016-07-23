package concurrency.domain;

public class CountingThread extends Thread {

    private static final String TO_STRING_FORMAT = "#%s: %d";
    private static int id = 0;

    private int countDown = 5;

    public CountingThread() {
        super(Integer.toString(id++));
        start();
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

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, getName(), countDown );
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new CountingThread();
        }
    }
}
