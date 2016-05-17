package concurrency;

import lombok.Getter;

public abstract class IntGenerator {

    @Getter private volatile boolean isCancelled = false;

    public abstract int next();

    public void cancel() {
        isCancelled = true;
    }

}
