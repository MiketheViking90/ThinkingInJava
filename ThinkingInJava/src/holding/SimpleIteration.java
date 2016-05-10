package holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import holding.domain.Pet;

public class SimpleIteration {

    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        Pet.fill(pets);

        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet pet = it.next();
            System.out.println(pet.getId() + ": " + pet.getName());
        }

        it = pets.iterator();
        for (int i = 0; i < 3; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }

}
