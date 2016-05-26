package concurrency.checkingforinterrupt;

public class NeedsCleanup {

    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
    }

    public void cleanup() {
        System.out.println("Cleaning up " + id);
    }

}
