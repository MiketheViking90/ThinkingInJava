package generics.domain;

import lombok.Getter;

public class Coffee {

    private static int counter = 0;

    @Getter private final int id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    public static void main(String[] args) {
        Coffee c = new Coffee();
    }
}
