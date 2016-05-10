package holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import holding.domain.Pet;

public class CrossContainerIteration {

    public static void display (Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.getId() + ": " + p + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        Pet.fill(pets);
        LinkedList<Pet> linkedPets = new LinkedList<>(pets);
        HashSet<Pet> hashPets = new HashSet<>(pets);
        TreeSet<Pet> treePets = new TreeSet<>(pets);

        fillAndDisplay(pets);
        fillAndDisplay(linkedPets);
        fillAndDisplay(hashPets);
        fillAndDisplay(treePets);
    }

    private static void fillAndDisplay(Collection<Pet> pets) {
        display(pets.iterator());
    }
}
