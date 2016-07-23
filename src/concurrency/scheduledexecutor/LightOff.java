package concurrency.scheduledexecutor;

public class LightOff implements Runnable {

    private Nest nest;

    public LightOff(Nest nest) {
        this.nest = nest;
    }

    @Override
    public void run() {
        nest.lightOff();
    }

}
