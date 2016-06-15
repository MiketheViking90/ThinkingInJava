package concurrency.delayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed, Runnable {

    private static int counter = 0;

    private final int id = counter++;
    private final int delta;
    private final long trigger;

    protected static List<DelayedTask> sequence =
            new ArrayList<>();


    public DelayedTask(int delayInMillis) {
        delta = delayInMillis;
        trigger = System.nanoTime() +
                TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed arg) {
        DelayedTask comparedTo = (DelayedTask) arg;
        if (trigger < comparedTo.trigger) {
            return -1;
        } else if (trigger > comparedTo.trigger) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public String toString() {
        return String.format("[%2d]", delta) +
                "Task " + id;
    }

}
