package concurrency.scheduledexecutor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrency.checkingforinterrupt.DayTemperature;
import concurrency.checkingforinterrupt.NightTemperature;

public class Nest {

    private int temperature = 70;
    private boolean light = false;

    public synchronized void setTemperature(int temp) {
        System.out.println("Setting temperature to " + temp);
        temperature = temp;
    }

    public synchronized void lightOff() {
        System.out.println("Turning light off");
        light = false;
    }

    public synchronized void lightOn() {
        System.out.println("Turning light on");
        light = true;
    }

    public static void main(String[] args) {
        Nest nest = new Nest();
        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

        Terminater terminate = new Terminater(scheduler);
        LightOn lightOn = new LightOn(nest);
        LightOff lightOff = new LightOff(nest);
        DayTemperature dayTemp = new DayTemperature(nest);
        NightTemperature nightTemp = new NightTemperature(nest);

        scheduler.schedule(terminate, 5000, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(lightOff, 0, 400, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(lightOn, 0, 200, TimeUnit.MILLISECONDS);

        scheduler.scheduleAtFixedRate(dayTemp, 0, 400, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(nightTemp, 200, 400, TimeUnit.MILLISECONDS);
    }
}
