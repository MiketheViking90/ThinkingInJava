package concurrency.beerpub;

public class WhiskeyDrinker implements Runnable {

    private OldFashioned oldFashioned;

    public WhiskeyDrinker(OldFashioned oldFashioned) {
        this.oldFashioned = oldFashioned;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                oldFashioned.waitForFilling();
                System.out.println("Drink the whiskey");
                oldFashioned.empty();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
