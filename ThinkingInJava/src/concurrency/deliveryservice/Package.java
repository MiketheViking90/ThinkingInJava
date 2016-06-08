package concurrency.deliveryservice;

public class Package {

    private int id;

    public Package(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Package " + id;
    }
}
