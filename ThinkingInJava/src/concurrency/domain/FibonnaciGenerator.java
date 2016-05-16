package concurrency.domain;

public class FibonnaciGenerator implements Runnable {

    public static int count = 0;

    private final int id = count++;
    private final int length;

    public FibonnaciGenerator(int n) {
        length = n;
    }

    @Override
    public void run() {
        int[] fibs = new int[length];
        fibs[0] = 1;
        System.out.println(id + ": " + 1);
        fibs[1] = 1;
        System.out.println(id + ": " + 1);

        for (int i = 2; i < length; i++) {
            fibs[i] = (fibs[i - 1] + fibs[ i - 2]);

            if (i == length - 1) {
                System.out.println(id + " DONE.");
            }
            System.out.println(id + ": " + fibs[i]);
        }
    }

    public static void main(String[] args) {
        FibonnaciGenerator fibs1 = new FibonnaciGenerator(10);
        FibonnaciGenerator fibs2 = new FibonnaciGenerator(5);
        FibonnaciGenerator fibs3 = new FibonnaciGenerator(7);
        FibonnaciGenerator fibs4 = new FibonnaciGenerator(12);

        Thread t1 = new Thread(fibs1);
        Thread t2 = new Thread(fibs1);
        Thread t3 = new Thread(fibs1);
        Thread t4 = new Thread(fibs1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
