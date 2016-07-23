package concurrency.checkingforinterrupt;

import concurrency.scheduledexecutor.Nest;

public class DayTemperature implements Runnable {

    private Nest nest;

    public DayTemperature(Nest nest) {
        this.nest = nest;
    }

    @Override
    public void run() {
        int temp = 72;
        nest.setTemperature(72);
    }

}
