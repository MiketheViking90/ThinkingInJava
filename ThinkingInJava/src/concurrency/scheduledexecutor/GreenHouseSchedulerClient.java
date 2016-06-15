package concurrency.scheduledexecutor;

public class GreenHouseSchedulerClient {

    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        gh.schedule(gh.new Terminate(), 5000);
        gh.repeat(gh.new LightOn(), 0, 200);
        gh.repeat(gh.new LightOff(), 0, 400);

        gh.repeat(gh.new WaterOn(), 0, 300);
        gh.repeat(gh.new WaterOff(), 0, 600);
    }

}
