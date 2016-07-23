package concurrency.domain;

public class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;

        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " is asleep");
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " is awake");
    }
}
