package concurrency.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Shopper implements Runnable {

    private static int count = 0;
    private Checkout checkout;

    public Shopper(Checkout checkout) {
        this.checkout = checkout;
    }

    @Override
    public void run() {
        while (true) {
            boolean purchaseItem = checkout.processCheckout();
            if (!purchaseItem) {
                System.err.println("could not checkout");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Checkout co = new Checkout();
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            Shopper s = new Shopper(co);
            exec.execute(s);
        }
        System.out.println("main thread done");
    }
}
