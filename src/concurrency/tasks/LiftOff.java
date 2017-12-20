package concurrency.tasks;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LiftOff implements Runnable {

    private static int taskCount = 0;

    protected int countDown = 10;
    private final int id = taskCount++;


    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    private String status() {
        String countDownMsg = (countDown != 0) ? String.valueOf(countDown) : "LiftOff!";
        return "#"+ id + ": " + countDownMsg;
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
