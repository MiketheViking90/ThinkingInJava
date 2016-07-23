package concurrency;

public class LiftOff implements Runnable {

    private static final String STATUS_FORMAT = "#%d (%s)";
    private static final String LIFTOFF = "LIFTOFF!";

    public static int taskCount = 0;

    protected int countDown = 10;
    private int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        String status = (countDown > 0 ) ? String.valueOf(countDown) : LIFTOFF;
        return String.format(STATUS_FORMAT, id, status);
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff lo1 = new LiftOff();
        LiftOff lo2 = new LiftOff();
        LiftOff lo3 = new LiftOff();
        LiftOff lo4 = new LiftOff();

        lo1.run();
        lo2.run();
        lo3.run();
        lo4.run();
    }
}
