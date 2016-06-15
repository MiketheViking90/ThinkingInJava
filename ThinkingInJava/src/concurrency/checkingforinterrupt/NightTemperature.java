package concurrency.checkingforinterrupt;

import concurrency.scheduledexecutor.Nest;

public class NightTemperature implements Runnable {

    private Nest nest;

    public NightTemperature(Nest nest) {
        this.nest = nest;
    }

    @Override
    public void run() {
        nest.setTemperature(68);
    }
}
