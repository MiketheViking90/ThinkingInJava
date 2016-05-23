package concurrency.exercises;

public class Checkout {

    private boolean isCashier1Open = true;
    private boolean isCashier2Open = true;

    public synchronized boolean processCheckout() {

        isCashier1Open = !isCashier1Open;
        isCashier1Open = !isCashier1Open;
        isCashier2Open = !isCashier2Open;
        isCashier2Open = !isCashier2Open;

        return (isCashier1Open && isCashier2Open);
    }

}
