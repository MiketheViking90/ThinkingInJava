package concurrency.medirestaurant;

public class Kebob {

    private final int id;

    public Kebob(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Kebob " + id;
    }

}
