package concurrency.exercises;

import lombok.Getter;

public class SharedResource {

    @Getter private boolean isOpen = false;

    public synchronized void useResource() {
        isOpen = false;
    }

    public synchronized void yieldResource() {
        isOpen = true;
    }

}
