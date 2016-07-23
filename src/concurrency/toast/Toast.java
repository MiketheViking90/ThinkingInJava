package concurrency.toast;

import lombok.Getter;

@Getter
public class Toast {

    public enum Status {
        DRY, BUTTERED, JAMMED, PBJED;
    }

    @Getter private boolean isJellyed = false;
    @Getter private boolean isPeanutButtered = false;

    private Status status = Status.DRY;
    private int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public void jelly() {
        isJellyed = true;
    }

    public void peanutButter() {
        isPeanutButtered = true;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }

}
