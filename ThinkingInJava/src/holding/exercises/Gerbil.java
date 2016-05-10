package holding.exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gerbil {

    private static final String HOP_DISPLAY_FORMAT = "%d is hopping";

    private static int count;

    private final int gerbilNumber;

    public Gerbil() {
        gerbilNumber = count++;
    }

    public void hop() {
        String msg = String.format(HOP_DISPLAY_FORMAT, gerbilNumber);
        System.out.println(msg);
    }

    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            gerbils.add(new Gerbil());
        }

        for (Gerbil gerbil : gerbils) {
            gerbil.hop();
        }

        Iterator<Gerbil> it = gerbils.iterator();
        while (it.hasNext()) {
            Gerbil g = it.next();
            g.hop();
        }
    }
}
