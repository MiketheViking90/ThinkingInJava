package concurrency.restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.Getter;
import lombok.Setter;

public class Restaurant {

    private static volatile Restaurant instance;

    @Getter private ExecutorService exec;
    @Getter @Setter private Meal meal;
    @Getter private Chef chef;
    @Getter private Waiter waiter;

    public static Restaurant getInstance() {
        if (instance == null) {
            synchronized(Restaurant.class) {
                if (instance == null) {
                    instance = new Restaurant();
                }
            }
        }
        return instance;
    }

    public void openDoors() {
        exec.execute(chef);
        exec.execute(waiter);
    }

    private Restaurant() {
        exec = Executors.newCachedThreadPool();
        chef = new Chef(this);
        waiter = new Waiter(this);
    };

    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();
        restaurant.openDoors();
    }
}
