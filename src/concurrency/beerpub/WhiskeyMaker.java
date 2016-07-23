package concurrency.beerpub;

public class WhiskeyMaker implements Runnable {

    private OldFashioned oldFashioned;

    public WhiskeyMaker(OldFashioned oldFashioned) {
        this.oldFashioned = oldFashioned;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Fill whiskey");
                oldFashioned.fill();
                oldFashioned.waitForEmptying();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
