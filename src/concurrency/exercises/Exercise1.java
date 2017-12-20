package concurrency.exercises;

public class Exercise1 implements Runnable {

    private static int taskCount = 0;

    private final int id = taskCount++;

    public Exercise1() {
        System.out.println(String.format("#%d created", id));
    }

    @Override
    public void run() {
        System.out.println("#" + id + " msg 1");
        Thread.yield();

        System.out.println("#" + id + " msg 2");
        Thread.yield();

        System.out.println("#" + id + " msg 3");
        Thread.yield();

        System.out.println(String.format("#%d has terminated", id));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Exercise1()).start();
        }
        System.out.println("Exercise 1 start");
    }
}
