package concurrency.exercises;

public class ResourceCheck implements Runnable {

    private SharedResource resource;

    public ResourceCheck(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true) {
            if (resource.isOpen()) {
                System.out.println("Check resource close");
                resource.useResource();
            }
        }
    }
}
