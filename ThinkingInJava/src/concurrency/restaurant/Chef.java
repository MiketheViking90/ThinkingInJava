package concurrency.restaurant;

public class Chef implements Runnable {

    private int count;
    private Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized(this) {
                    while (restaurant.getMeal() != null) {
                        wait(); // Wait for the meal to be consumed by Waiter (Consumer)
                    }
                }
                if (++count == 10) {
                    System.out.println("Out of food. Closing");
                    restaurant.getExec().shutdownNow();
                }
                System.out.println("Chef: Order up! ");
                synchronized(restaurant.getWaiter()) {
                    restaurant.setMeal(new Meal(count));
                    restaurant.getWaiter().notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this.getClass().getSimpleName() + ": " + e);
        }
    }
}
