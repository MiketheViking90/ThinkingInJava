package concurrency.deliveryservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.Getter;
import lombok.Setter;

public class DeliveryService {

    private volatile static DeliveryService instance;

    @Getter private final ExecutorService exec = Executors.newCachedThreadPool();

    @Getter @Setter private Package pkg;
    @Getter @Setter private Courier courier;
    @Getter @Setter private Sender sender;
    @Getter @Setter private Receiver receiver;
    @Getter private boolean isPackageInTransit;

    public static DeliveryService getInstance() {
        if (instance == null) {
            synchronized(DeliveryService.class) {
                if (instance == null) {
                    instance = new DeliveryService();
                }
            }
        }
        return instance;
    }

    public void startBusinessHours() {
        exec.execute(courier);
        exec.execute(sender);
    }

    private DeliveryService() {
        courier = new Courier(this);
        sender = new Sender(this);
        receiver = new Receiver(this);
    }

    public static void main(String[] args) {
        DeliveryService service = DeliveryService.getInstance();
        service.startBusinessHours();
    }

    public void packageStatusInTransit() {
        isPackageInTransit = true;
    }

    public void packageStatusReceived() {
        isPackageInTransit = false;
    }
}
