package concurrency.restaurant;

public class Waiter implements Runnable {

    private Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.getMeal() == null) {
                        wait(); // wait for chef (Producer) to make meal
                    }
                }
                System.out.println("Waiter has meal: " + restaurant.getMeal());
                synchronized(restaurant.getChef()) {
                    restaurant.setMeal(null);
                    restaurant.getChef().notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this.getClass().getSimpleName() + ": " + e);
        }
    }
}
