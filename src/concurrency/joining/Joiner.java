package concurrency.joining;

public class Joiner extends Thread {

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;

        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " join complete");
    }

    public static void main(String[] args) {
        Sleeper sleep1 = new Sleeper("sleep1", 1500);
        Sleeper sleep2 = new Sleeper("sleep2", 1500);

        Joiner join1 = new Joiner("join1", sleep1);
        Joiner join2 = new Joiner("join2", sleep2);

        sleep2.interrupt();
    }
}
