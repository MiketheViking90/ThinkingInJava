package concurrency.medirestaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.Getter;
import lombok.Setter;

public class PetraMediterraneanBistro {

    private final ExecutorService exec;

    @Getter @Setter private Kebob kebob;
    @Getter @Setter private Table table;

    @Getter private PetraChef chef;
    @Getter private PetraWaiter waiter;
    @Getter private PetraBusBoy busBoy;

    public boolean isReadyForChef() {
        return !hasKebob() && table.isClean();
    }

    public boolean isReadyForWaiter() {
        return hasKebob() && table.isClean();
    }

    public boolean isReadyForBusboy() {
        return !hasKebob() && !table.isClean();
    }

    public void seatCustomer() {
        table.seatGuests();
    }

    public boolean hasKebob() {
        return kebob != null;
    }

    public PetraMediterraneanBistro() {
        exec = Executors.newCachedThreadPool();
        waiter = new PetraWaiter(this);
        chef = new PetraChef(this);
        busBoy = new PetraBusBoy(this);
        table = new Table();
    }

    public void open() {
        exec.execute(waiter);
        exec.execute(chef);
        exec.execute(busBoy);
    }

    public void close() {
        exec.shutdownNow();
    }

    public static void main(String[] args) {
        PetraMediterraneanBistro bistro = new PetraMediterraneanBistro();
        bistro.open();
    }

}
