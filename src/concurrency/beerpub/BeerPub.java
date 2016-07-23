package concurrency.beerpub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BeerPub {

    public static void main(String[] args) throws InterruptedException {
        runWhiskeyBar();
    }

    private static void runBeerPub() throws InterruptedException {
        Mug mug = new Mug();
        Bartender bartender = new Bartender(mug);
        Drinker drinker = new Drinker(mug);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(bartender);
        exec.execute(drinker);
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }

    public static void runWhiskeyBar() throws InterruptedException {
        OldFashioned oldFashioned = new OldFashioned();
        WhiskeyDrinker drinker = new WhiskeyDrinker(oldFashioned);
        WhiskeyMaker maker = new WhiskeyMaker(oldFashioned);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(maker);
        exec.execute(drinker);
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
