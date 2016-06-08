package concurrency.coffeeshop;

import lombok.Getter;

public class Coffee {

    @Getter private int id;

    public Coffee(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Coffee " + id;
    }
}
