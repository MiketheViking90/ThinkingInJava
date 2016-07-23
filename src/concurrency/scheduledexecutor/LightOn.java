package concurrency.scheduledexecutor;

public class LightOn implements Runnable {

    private Nest nest;

    public LightOn(Nest nest) {
        this.nest = nest;
    }

    @Override
    public void run() {
        nest.lightOn();
    }

}
