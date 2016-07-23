package concurrency.scheduledexecutor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenhouseScheduler {

    private volatile boolean light = false;
    private volatile boolean water = false;


    private ScheduledThreadPoolExecutor scheduler =
            new ScheduledThreadPoolExecutor(10);
    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    public void schedule(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, long initDelay, long pd) {
        scheduler.scheduleAtFixedRate(event, initDelay, pd, TimeUnit.MILLISECONDS);
    }

    class LightOn implements Runnable {
        @Override
        public void run() {
            if (!light) {
                System.out.println("Turning lights on");
                light = true;
            }
        }
    }

    class LightOff implements Runnable {
        @Override
        public void run() {
            if (light) {
                System.out.println("Turning lights off");
                light = false;
            }
        }
    }

    class WaterOn implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning water on");
            water = true;
        }
    }

    class WaterOff implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning water off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to night settings");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to day settings");
            setThermostat("Day");
        }
    }

    class Terminate implements Runnable {
        @Override
        public void run() {
            System.out.println("Terminating");
            scheduler.shutdownNow();
        }
    }
}
