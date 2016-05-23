package concurrency.criticalsection;

import lombok.Getter;

public class Pair {

    @Getter private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public void checkState() {
        if (x != y) {
            throw new IllegalStateException("Pair values not equal. " + this);
        }
    }

}
