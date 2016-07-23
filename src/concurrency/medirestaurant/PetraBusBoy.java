package concurrency.medirestaurant;

public class PetraBusBoy implements Runnable {

    private final PetraMediterraneanBistro bistro;

    public PetraBusBoy(PetraMediterraneanBistro bistro) {
        this.bistro = bistro;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized(this) {
                    while(!bistro.isReadyForBusboy()) {
                        wait();
                    }
                }
                System.out.println("Cleaning table");
                System.out.println();
                PetraChef chef = bistro.getChef();
                synchronized(chef) {
                    bistro.getTable().cleanTable();
                    chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Busboy interrupted " + e);
        }
    }

}
