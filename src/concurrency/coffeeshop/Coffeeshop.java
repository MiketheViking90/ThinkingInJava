package concurrency.coffeeshop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.Getter;
import lombok.Setter;

public class Coffeeshop {

    @Getter private Barista barista;
    @Getter private Waiter waiter;
    @Getter @Setter private Coffee coffee;
    public ExecutorService exec = Executors.newCachedThreadPool();

    public Coffeeshop() {
        barista = new Barista(this);
        waiter = new Waiter(this);

        exec.execute(barista);
        exec.execute(waiter);
    }

    public boolean hasCoffee() {
        return coffee == null;
    }

    public void consumeCoffee() {
        coffee = null;
    }


    public void closeShop() {
        exec.shutdownNow();
    }

    public static void main(String[] args) {
        Coffeeshop cs = new Coffeeshop();
    }
}
